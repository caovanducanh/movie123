package hsf302.myMovie.controllers;

import hsf302.myMovie.models.Comment;
import hsf302.myMovie.models.Movie;
import hsf302.myMovie.models.User;
import hsf302.myMovie.services.CommentService;
import hsf302.myMovie.services.MovieService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    private final MovieService movieService;

    @Autowired
    public CommentController(CommentService commentService, MovieService movieService) {
        this.commentService = commentService;
        this.movieService = movieService;
    }

    @PostMapping("/{movieId}")
    public String addComment(@PathVariable int movieId, @RequestParam String content, HttpSession session, Model model) {
        // Lấy thông tin người dùng từ session
        Object userObj = session.getAttribute("acc");
        User user = (User) userObj;
        String fullName = user.getFullName();  // Lấy fullName của người dùng đã đăng nhập

        // Tạo đối tượng Comment và gán thông tin
        Comment comment = new Comment();
        comment.setFullName(fullName);
        comment.setContent(content);
        comment.setCreatedAt(java.time.LocalDateTime.now()); // Cập nhật thời gian tạo
        Optional<Movie> movieOptional = movieService.getMovieById(movieId);
        if (movieOptional.isPresent()) {
            comment.setMovie(movieOptional.get()); // Gán movie vào comment
        } else {
            model.addAttribute("error", "Không tìm thấy bộ phim này.");
            return "error"; // Trả về trang lỗi nếu không tìm thấy bộ phim
        }

        // Lưu bình luận vào cơ sở dữ liệu
        commentService.addComment(comment);
        return "redirect:/getmoviebyid?id=" + movieId; // Chuyển hướng về trang chi tiết bộ phim
    }

    // API để lấy tất cả bình luận của một bộ phim
//    @GetMapping("/{movieId}")
//    public String getCommentsByMovie(@PathVariable int movieId, Model model) {
//        // Lấy tất cả các bình luận của bộ phim từ service
//        List<Comment> comments = commentService.getAllCommentsByMovie(movieId);
//
//        // Thêm danh sách bình luận vào model
//        model.addAttribute("comments", comments);
//
//        // Trả về view để hiển thị các bình luận
//        return "detail"; // Đảm bảo trả về view tương ứng
//    }

//    // API để lấy bình luận theo ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Comment> getCommentById(@PathVariable int id) {
//        Optional<Comment> comment = commentService.getCommentById(id);
//
//        // Kiểm tra nếu không tìm thấy bình luận, trả về 404
//        if (!comment.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Trả về 404 nếu không tìm thấy
//        }
//
//        // Nếu tìm thấy bình luận, trả về bình luận đó
//        return ResponseEntity.ok(comment.get());
//    }
//
//    // API để xóa bình luận theo ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteComment(@PathVariable int id) {
//        commentService.deleteComment(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/comments/{movieId}")
//    public String showComments(@PathVariable int movieId, Model model) {
//        // Lấy danh sách các bình luận từ service dựa vào movieId
//        List<Comment> comments = commentService.getAllCommentsByMovie(movieId);
//        model.addAttribute("comments", comments); // Đưa danh sách bình luận vào model
//        return "detail"; // Trả về view để hiển thị bình luận (ví dụ: commentsPage.html)
//    }
}

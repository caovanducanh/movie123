package hsf302.myMovie.services;

import hsf302.myMovie.models.Comment;
import hsf302.myMovie.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }


    public Comment addComment(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepo.save(comment);
    }


    public List<Comment> getAllCommentsByMovie(int movieId) {
        return commentRepo.findAllByMovieId(movieId);
    }


}

package hsf302.myMovie.repo;

import hsf302.myMovie.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByMovieId(int movieId);
}

package hsf302.myMovie.repo;

import hsf302.myMovie.models.FavoriteMovie;
import hsf302.myMovie.models.Movie;
import hsf302.myMovie.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteMovieRepo extends JpaRepository<FavoriteMovie,Integer> {
    List<FavoriteMovie> findByUser(User user);

}

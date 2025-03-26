package hsf302.myMovie.repo;

import hsf302.myMovie.models.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteMovieRepo extends JpaRepository<FavoriteMovie,Integer> {
}

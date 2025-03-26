package hsf302.myMovie.repo;

import hsf302.myMovie.models.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreRepo extends JpaRepository<MovieGenre ,Integer> {
}

package hsf302.myMovie.repo;

import hsf302.myMovie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie ,Integer> {
}

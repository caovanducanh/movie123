package hsf302.myMovie.services;

import hsf302.myMovie.models.Movie;
import hsf302.myMovie.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public List<Movie> getMovieByName(String name) {
        return movieRepository.findByMovieNameContainingIgnoreCase(name);
    }

    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}

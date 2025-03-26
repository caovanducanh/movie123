package hsf302.myMovie.controllers;

import hsf302.myMovie.models.Country;
import hsf302.myMovie.models.Movie;
import hsf302.myMovie.models.MovieGenre;
import hsf302.myMovie.services.CountryService;
import hsf302.myMovie.services.MovieGenreService;
import hsf302.myMovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieGenreService movieGenreService;

    @Autowired
    private CountryService countryService;


    @GetMapping("/home")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/manage-movies")
    public String getAllMoviesList(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movie-list";
    }

    @GetMapping("/getmoviebyid")
    public String getMovieById(@RequestParam(name = "id") int id, Model model) {
        Optional<Movie> movieOptional = movieService.getMovieById(id);

        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            model.addAttribute("movie", movie);

            List<MovieGenre> movieGenres = movieGenreService.getMovieGenresByMovieId(movie.getId());
            model.addAttribute("movieGenres", movieGenres);

                return "detail";
        }

        return "redirect:/movies"; // Nếu không tìm thấy phim, chuyển hướng về danh sách phim
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Movie movieEmpty = new Movie();
        model.addAttribute("movie", movieEmpty);
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "movie-form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies/home";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Movie> movie = movieService.getMovieById(id);
        movie.ifPresent(value -> model.addAttribute("movie", value));
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "movie-form";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable int id, @ModelAttribute Movie movie) {
        movie.setId(id);
        movieService.saveMovie(movie);
        return "redirect:/movies/manage-movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return "redirect:/movies/manage-movies";
    }
    @GetMapping
    public String getMoviesByName(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Movie> movies;
        if (keyword != null && !keyword.isEmpty()) {
            movies = movieService.getMovieByName(keyword);
        } else {
            movies = movieService.getAllMovies();
        }
        model.addAttribute("movies", movies);
        model.addAttribute("keyword", keyword);
        return "home";
    }

}

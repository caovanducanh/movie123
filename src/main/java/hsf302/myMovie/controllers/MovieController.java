package hsf302.myMovie.controllers;

import hsf302.myMovie.models.Movie;
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


    @GetMapping("/home")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/create";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Movie> movie = movieService.getMovieById(id);
        movie.ifPresent(value -> model.addAttribute("movie", value));
        return "movies/edit";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable int id, @ModelAttribute Movie movie) {
        movie.setId(id);
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
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
        return "movies/index";
    }

}

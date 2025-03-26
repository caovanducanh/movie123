package hsf302.myMovie.config;

import hsf302.myMovie.models.*;
import hsf302.myMovie.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    private
    UserRepo Userrepo ;
    @Autowired
    private MovieRepo movieRepo ;
    @Autowired
    private FavoriteMovieRepo favoriteMovieRepo ;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private GenreRepo genreRepo ;
    @Autowired
    private MovieGenreRepo movieGenreRepo ;
    @Autowired
    private CommentRepo commentRepo;


    @Override
    public void run(String... args) throws Exception {

        User admin = new User("ADMIN", "Nguyen Van A", "Admin@gmail.com", "123", 1);
        Userrepo.save(admin);

        User member1 = new User("member1", "Nguyen Van B", "member1@gmail.com", "123", 2);
        Userrepo.save(member1);

        User member2 = new User("member2", "Nguyen Van C", "member2@gmail.com", "123", 2);
        Userrepo.save(member2);

        User member3 = new User("member3", "Nguyen Van D", "member2@gmail.com", "123", 2);

        Userrepo.save(admin);
        Userrepo.save(member1);
        Userrepo.save(member2);
        Userrepo.save(member3);

        // Thêm Country
        Country usa = new Country();
        usa.setCountryName("United States");
        countryRepo.save(usa);

        Country uk = new Country();
        uk.setCountryName("United Kingdom");
        countryRepo.save(uk);

        Country france = new Country();
        france.setCountryName("France");
        countryRepo.save(france);

        Country japan = new Country();
        japan.setCountryName("Japan");
        countryRepo.save(japan);


        // Thêm Genre
        Genre action = new Genre();
        action.setGenreName("Action");
        genreRepo.save(action);

        Genre comedy = new Genre();
        comedy.setGenreName("Comedy");
        genreRepo.save(comedy);

        Genre drama = new Genre();
        drama.setGenreName("Drama");
        genreRepo.save(drama);

        Genre horror = new Genre();
        horror.setGenreName("Horror");
        genreRepo.save(horror);

        Genre sciFi = new Genre();
        sciFi.setGenreName("Sci-Fi");
        genreRepo.save(sciFi);

        Genre adventure = new Genre();
        adventure.setGenreName("Adventure");
        genreRepo.save(adventure);


        // Thêm Movie
        Movie movie1 = new Movie();
        movie1.setMovieName("Inception");
        movie1.setDescription("A mind-bending thriller by Christopher Nolan.");
        movie1.setReleaseYear(2010);
        movie1.setRating(9);
        movie1.setMovieURL("https://example.com/inception");
        movie1.setThumbnailURL("https://example.com/inception_thumbnail.jpg");
        movie1.setTrailerURL("https://example.com/inception_trailer.mp4");
        movie1.setCountry(usa);
        movieRepo.save(movie1);

        // Gán MovieGenre cho Movie (Inception)
        MovieGenre mg1 = new MovieGenre();
        mg1.setMovie(movie1);
        mg1.setGenre(action);
        movieGenreRepo.save(mg1);

        MovieGenre mg2 = new MovieGenre();
        mg2.setMovie(movie1);
        mg2.setGenre(sciFi);
        movieGenreRepo.save(mg2);

        MovieGenre mg3 = new MovieGenre();
        mg3.setMovie(movie1);
        mg3.setGenre(adventure);
        movieGenreRepo.save(mg3);




        // Thêm Comment cho Movie (Inception)
        Comment comment1 = new Comment("John Doe", "A masterpiece of Nolan!", LocalDateTime.now(), movie1);
        Comment comment2 = new Comment("Alice Smith", "Mind-blowing and visually stunning!", LocalDateTime.now(), movie1);
        Comment comment3 = new Comment("David Johnson", "Great storytelling and concept.", LocalDateTime.now(), movie1);

        commentRepo.save(comment1);
        commentRepo.save(comment2);
        commentRepo.save(comment3);
        System.out.println("Data initialized successfully");


    }
}

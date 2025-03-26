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


        // Thêm nhiều phim
        String[][] movies = {
                {"Interstellar", "A sci-fi journey through space and time.", "2014", "9", "https://example.com/interstellar", "https://cdn2.tuoitre.vn/thumb_w/1200/471584752817336320/2025/2/28/interstellar-1740030627-174003-3997-2700-1740030837-17407532558271386299933-32-177-571-1207-crop-17407533212841333151791.jpg", "https://example.com/interstellar_trailer"},

                {"The Dark Knight", "Batman fights Joker in Gotham.", "2008", "9", "https://example.com/dark_knight", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ77pn9nAtHPaqM6EGK28nO7niXSMxgHsMdBA&s", "https://example.com/dark_knight_trailer"},

                {"Titanic", "A romantic drama set on the ill-fated Titanic.", "1997", "8", "https://example.com/titanic", "https://example.com/titanic_thumb", "https://example.com/titanic_trailer"},
                {"Avatar", "An epic sci-fi adventure on Pandora.", "2009", "8", "https://example.com/avatar", "https://example.com/avatar_thumb", "https://example.com/avatar_trailer"},

                {"The Matrix", "A hacker discovers the truth about reality.", "1999", "9", "https://example.com/matrix", "https://example.com/matrix_thumb", "https://example.com/matrix_trailer"},
                {"Gladiator", "A Roman general seeks revenge.", "2000", "9", "https://example.com/gladiator", "https://example.com/gladiator_thumb", "https://example.com/gladiator_trailer"},

                {"Joker", "The origin story of the iconic villain.", "2019", "8", "https://example.com/joker", "https://example.com/joker_thumb", "https://example.com/joker_trailer"},

                {"Forrest Gump", "The extraordinary life of Forrest Gump.", "1994", "9", "https://example.com/forrest_gump", "https://example.com/forrest_gump_thumb", "https://example.com/forrest_gump_trailer"},

                {"The Godfather", "A mafia family's rise and struggles.", "1972", "10", "https://example.com/godfather", "https://example.com/godfather_thumb", "https://example.com/godfather_trailer"},

                {"Pulp Fiction", "Intertwined crime stories in LA.", "1994", "9", "https://example.com/pulp_fiction", "https://example.com/pulp_fiction_thumb", "https://example.com/pulp_fiction_trailer"}
        };

        for (String[] movieData : movies) {
            Movie movie = new Movie();
            movie.setMovieName(movieData[0]);
            movie.setDescription(movieData[1]);
            movie.setReleaseYear(Integer.parseInt(movieData[2]));
            movie.setRating(Integer.parseInt(movieData[3]));
            movie.setMovieURL(movieData[4]);
            movie.setThumbnailURL(movieData[5]);
            movie.setTrailerURL(movieData[6]);
            movie.setCountry(usa);
            movieRepo.save(movie);
        }



        System.out.println("Data initialized successfully");


    }
}

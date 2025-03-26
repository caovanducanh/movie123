package hsf302.myMovie.config;

import hsf302.myMovie.models.*;
import hsf302.myMovie.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;


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
                {"Interstellar", "A sci-fi journey through space and time.", "2014", "9", "https://mega.nz/embed/q45lmCBL#u3LP4bXNEQ78Bgf7MlOjygCZqKUBr5i-G7u9NnLewwgr", "https://m.media-amazon.com/images/I/91vIHsL-zjL._AC_UF1000,1000_QL80_.jpg", "https://www.youtube.com/watch?v=zSWdZVtXT7E"},

                {"The Dark Knight", "Batman fights Joker in Gotham.", "2008", "9", "https://example.com/dark_knight", "https://play-lh.googleusercontent.com/auIs5tjWlLYaFPGClZOJ7m5YVbnX6uBvz0X02r8TkwFKdzE53ww2MqWSS9gU0YNqoYwvpg", "https://example.com/dark_knight_trailer"},

                {"Titanic", "A romantic drama set on the ill-fated Titanic.", "1997", "8", "https://example.com/titanic", "https://upload.wikimedia.org/wikipedia/vi/a/ab/Titanic_3D_poster_Vietnam.jpg", "https://example.com/titanic_trailer"},

                {"Avatar", "An epic sci-fi adventure on Pandora.", "2009", "8", "https://example.com/avatar", "https://play-lh.googleusercontent.com/VMPS_t-CGBp-NVqefuMvMOGEDfmovBcGiepmAAF1I9hkdjLOjsfVjEV5d41DTAy3qI_akNaJKTdmaNwMRIs=w240-h480-rw", "https://example.com/avatar_trailer"},

                {"The Matrix", "A hacker discovers the truth about reality.", "1999", "9", "https://example.com/matrix", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQscJz2jJQ2Q4BJHx_WBSYqCVidQDu_Ir8U5w&s", "https://example.com/matrix_trailer"},

                {"Gladiator", "A Roman general seeks revenge.", "2000", "9", "https://example.com/gladiator", "https://upload.wikimedia.org/wikipedia/en/f/fb/Gladiator_%282000_film_poster%29.png", "https://example.com/gladiator_trailer"},

                {"Joker", "The origin story of the iconic villain.", "2019", "8", "https://example.com/joker", "https://i.pinimg.com/originals/8b/f6/6f/8bf66fb9f8aa2725ccc423c3551b0580.jpg", "https://example.com/joker_trailer"},

                {"Forrest Gump", "The extraordinary life of Forrest Gump.", "1994", "9", "https://example.com/forrest_gump", "https://levushop.com/wp-content/uploads/2022/09/tong-hop-cau-noi-hay-cua-forrest-gump.jpg", "https://example.com/forrest_gump_trailer"},

                {"The Godfather", "A mafia family's rise and struggles.", "1972", "10", "https://example.com/godfather", "https://kienviet.net/wp-content/uploads/2022/12/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", "https://example.com/godfather_trailer"},

                {"Pulp Fiction", "Intertwined crime stories in LA.", "1994", "9", "https://example.com/pulp_fiction", "https://musicart.xboxlive.com/7/767c6300-0000-0000-0000-000000000002/504/image.jpg", "https://example.com/pulp_fiction_trailer"}
        };

        Movie movie123 = new Movie(
                "Interstellar",
                "A sci-fi journey through space and time.",
                2014,
                9,
                "https://mega.nz/embed/q45lmCBL#u3LP4bXNEQ78Bgf7MlOjygCZqKUBr5i-G7u9NnLewwg",
                "https://m.media-amazon.com/images/I/91vIHsL-zjL._AC_UF1000,1000_QL80_.jpg",
                "https://www.youtube.com/watch?v=zSWdZVtXT7E",
                usa
        );
        movieRepo.save(movie123);

        MovieGenre movieGenre = new MovieGenre(
                movie123,
                action
        );

        MovieGenre movieGenre1 = new MovieGenre(
                movie123,
                comedy
        );
        movieGenreRepo.save(movieGenre);
        movieGenreRepo.save(movieGenre1);










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

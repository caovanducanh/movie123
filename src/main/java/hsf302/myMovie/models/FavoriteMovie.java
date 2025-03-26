package hsf302.myMovie.models;

import jakarta.persistence.*;

@Entity
@Table(name = "favoriteMovie")
public class FavoriteMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteMovieID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User User;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MovieID")
    private Movie Movie;

    public FavoriteMovie() {
    }

    public FavoriteMovie(User user, Movie movie) {
        User = user;
        Movie = movie;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public Movie getMovie() {
        return Movie;
    }

    public void setMovie(Movie movie) {
        Movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package hsf302.myMovie.repo;

import hsf302.myMovie.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}

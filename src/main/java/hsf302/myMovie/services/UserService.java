package hsf302.myMovie.services;

import hsf302.myMovie.models.User;
import hsf302.myMovie.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);

    }

    public User findByUserId(int userId) {
        return userRepo.findByUserId(userId);
    }
}

package hsf302.myMovie.services;

import hsf302.myMovie.models.User;
import hsf302.myMovie.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);

    }

    public User findByid(int id) {
        return userRepo.findById(id);
    }
}

package com.revature.services;

import com.revature.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserServiceImpl userService;

    public AuthServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userService.findByCredentials(email, password);
    }

    public User register(User user) {
        return userService.save(user);
    }

    @Override
    //TODO replace userId with UUID if allowed
    public boolean forgotPassword(String email, int userId){
        if(userService.findByEmail(email)) {
            System.out.println("email sent");
            //TODO POST to reset reset request table {uuid,timestamp,userId}, if we end up being allowed to implement it
            userService.sendEmail(email, userId);
            return true;
        }
        return false;
    }
    @Override
    public Optional<User> findByUserId(Integer id) {
        return userService.findById(id);
    }
}

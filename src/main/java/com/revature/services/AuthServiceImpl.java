package com.revature.services;

import com.revature.exceptions.ExpiredRequestException;
import com.revature.models.ResetRequest;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserService userService;
    @Autowired
    private ResetService resetService;

    public Optional<User> findByCredentials(String email, String password){
        Optional<User> optionalUser = userService.findByEmail(email);
        if (!optionalUser.isPresent()) return optionalUser;

        User existingUser = optionalUser.get();
        if (User.encryptPassword(password, existingUser.getSaltBytes()).equals(existingUser.getPassword()))
            return optionalUser;

        return Optional.empty();
    }

    public User register(User user){
        user.encryptAndSetPassword();
        return userService.save(user);
    }

    private byte[] SaltMaker() {
        byte[] randBytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(randBytes);
        return randBytes;
    }
  
    @Override
    //TODO replace id with UUID
    public void forgotPassword(String email){
            Optional<User> user = userService.findByEmail(email);
            if(user.isPresent()){
                ResetRequest request = resetService.createEntry();
                userService.sendEmail(email, request.getId());
            }
    }

    public User resetPassword(String password,int resetId) throws ExpiredRequestException {

        ResetRequest resetRequest = resetService.findById(resetId);
        if(resetService.compareTimestamp(resetRequest.getTimeStamp())){
            return resetService.reset(password, resetRequest);
        }


        throw new ExpiredRequestException();
    }

    @Override
    public Optional<User> findByUserId(Integer id){
        return userService.findById(id);
    }
}

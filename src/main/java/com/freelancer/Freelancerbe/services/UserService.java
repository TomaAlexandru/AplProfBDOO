package com.freelancer.Freelancerbe.services;

import com.freelancer.Freelancerbe.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelancer.Freelancerbe.model.entities.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(String email, String password) {
        User user = new User();

        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);
    }
}
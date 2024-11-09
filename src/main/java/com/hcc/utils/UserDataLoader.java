package com.hcc.utils;

import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.repositories.AuthorityRepository;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserDataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
        loadAuthorityData();
    }

    public void loadUserData() {
        System.out.println("Loading user data...");
        if (userRepository.count() == 0) {
            PasswordEncoder pwEnc = new BCryptPasswordEncoder();
            String password = pwEnc.encode("testPassword");
            User user = new User(LocalDate.now(), "testUsername", password);
            userRepository.save(user);
        }
    }

    public void loadAuthorityData() {
        System.out.println("Loading authority data...");
        if (authorityRepository.count() == 0) {
            Authority learner = new Authority("ROLE_LEARNER", userRepository.findByUsername("testUsername").get());
            authorityRepository.save(learner);
        }
    }
}

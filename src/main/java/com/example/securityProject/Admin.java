package com.example.securityProject;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Admin
{
    @Autowired
    userRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder;

    String username = "admin";
    String password = "admin123";

    @PostConstruct
    public void createAmin()
    {
        if(repo.findByUserName(username).isEmpty())
        {
            users admin = new users();
            admin.setUsername(username);
            admin.setPassword(passwordEncoder.encode(password));
            admin.setRole("ROLE_ADMIN");
            repo.save(admin);
        }

    }
}

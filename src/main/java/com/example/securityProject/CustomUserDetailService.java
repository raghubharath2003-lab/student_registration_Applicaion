package com.example.securityProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService
{
    @Autowired
    StudentRepository sRepo;

    @Autowired
    userRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return repo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void addStudent(users u)
    {
//        Student student = new Student();
//        student.setName(SDTO.getUsername());
//        student.setUsername(SDTO.getUsername());
//        student.setPassword(passwordEncoder.encode(SDTO.getPassword()));
//        student.setRole("ROLE_STUDENT");
//        sRepo.save(student);
        users user = new users();
        user.setUsername(u.getUsername());
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.setRole("ROLE_STUDENT");
        repo.save(user);


    }


}

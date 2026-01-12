package com.example.securityProject;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller
{
    @Autowired
    CustomUserDetailService ser;

    @GetMapping("/fruits")
    public String greet()
    {
        return "FRUITS";
    }
    @GetMapping("/vegetables")
    public String vegetables()
    {
           return "VEGETABLES" ;
    }
    @PostMapping("/add/student")
    public String createStudent(@RequestBody users u)
    {
        ser.addStudent(u);
        return "Student Created Successfully";
    }


}

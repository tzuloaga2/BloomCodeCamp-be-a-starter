package com.hcc.controllers;

import com.hcc.entities.Hello;
import com.hcc.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcc.services.UserDetailsServiceImpl;

// this is an example controller feel free to delete this once you have created your own.
@RestController
@RequestMapping("/hellotest")
public class HelloController {
    @Autowired
    HelloService helloService;
    @GetMapping
    ResponseEntity<?> welcomeLearner() {
        Hello greeting = helloService.greetLearner();
        return ResponseEntity.ok(greeting);
    }
}


//Get Assignment By Id /api/assignments/{id}
//Put Assignment by Id /api/assignments/{id}
//Post Assignment /api/assignments

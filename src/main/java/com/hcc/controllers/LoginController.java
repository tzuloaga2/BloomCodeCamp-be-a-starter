package com.hcc.controllers;

import com.hcc.dtos.AuthCredentialRequestDto;
import com.hcc.entities.User;
import com.hcc.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class LoginController {

    //add authentication manager and jwtutils to generate jwt token to pass
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtils jwtUtils;

    //    the login would be a POST mapping as we are posting the login details to the server to return us a generated jwt
    //    frontend sends a username and password to an endpoint as the request body.
//    the endpoint uses the auth manager to generate a token to pass along
//    then extract user using the get principal method
//    set the password to null to make sure we are not sending paswords in our token
//    create a response entity with the auth header and a generated jwt token in the headers and the user object in the body of the response.

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthCredentialRequestDto authCredentialRequestDto) throws Exception {
        try{
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(authCredentialRequestDto.getUsername(),
                        authCredentialRequestDto.getPassword()));
    User user = (User) authentication.getPrincipal();
    user.setPassword(null);
    return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtUtils.generateToken(user)).body("Login SUCCESS");
        } catch (BadCredentialsException exception){
            throw new Exception("Credentials NOT valid");
        }
    }

}

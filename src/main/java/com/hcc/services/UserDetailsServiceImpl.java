package com.hcc.services;

import com.hcc.entities.User;
import com.hcc.repositories.UserRepository;
import com.hcc.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> userOpt = userRepository.findByUsername(username);
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(customPasswordEncoder.getPasswordEncoder().encode("asdfasdf"));
        return userOpt.orElseThrow(()-> new UsernameNotFoundException(("Invalid Credentials")));
    }

}
//sprint 2
//added dependecy, jwtfilter, autowired filter, added configuration, wrote jwtfilter,
// wrote userrepository, updated implementation user detail, added jwt util, added jwtfilter to settings file
// final thing to do: endpoints :)


//Look at services!
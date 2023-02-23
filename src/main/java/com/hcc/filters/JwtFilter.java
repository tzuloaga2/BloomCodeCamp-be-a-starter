package com.hcc.filters;

import com.hcc.repositories.UserRepository;
import com.hcc.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;

import static org.springframework.util.ObjectUtils.isEmpty;




@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtils jwtUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(isEmpty(header)|| !header.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        //if above is valid, get jwt token
        final String token = header.split(" ")[1].trim();

        // get user's identity
        UserDetails userDetails = userRepository.findByUsername(jwtUtils.getUsernameFromToken(token)).orElse(null);

        if(!jwtUtils.validateToken(token, userDetails)){
            filterChain.doFilter(request,response);
            return;
        }

        // create authentication
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken
                (userDetails, null, userDetails == null ? List.of() : userDetails.getAuthorities());

        // set auth details
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        //get the context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}

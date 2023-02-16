package com.hcc.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
/*
to add:
id : Long
cohortStartDate: Date
username: String
password: String
authorities: List
 */

@Entity
@Table(name = "users")
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cohortStartDate")
    private LocalDate cohortStartDate;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
   @JsonIgnore
   private List<Authority> authorities;

    //no args constructor
    public User(){}

    //constructor
    public User(String username, String password, LocalDate cohortStartDate) {

        List<Authority> authorities = null;
        this.username = username;
        this.password = password;
        this.cohortStartDate = cohortStartDate;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> roles = new ArrayList<>();
//        roles.add(new Authority("role_learner"));
//        //after doing validiation
//        return authorities;
////        return roles;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> roles = new ArrayList<>();
////        roles.add(new Authority("role_learner"));
//           return roles;
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCohortStartDate() {
        return cohortStartDate;
    }

    public void setCohortStartDate(LocalDate cohortStartDate) {
        this.cohortStartDate = cohortStartDate;
    }

//    public List<Authority> getAuthorities() {
//        return authorities;
//    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}

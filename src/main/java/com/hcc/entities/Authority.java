package com.hcc.entities;

///*
// to add for Authority class:
// id: Long
//authority: String
//user: User
//*/
//
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authoritylevel")
public class Authority implements GrantedAuthority  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private String authority;

    //see further if needs to know if optional or not
    @ManyToOne
    private User user;

    public Authority(){}
    public Authority(String authority){
        this.authority = authority;
        this.user = user;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

package com.hcc.dtos;

public class AuthCredentialRequestDto {

    //same as a login class
    private String username;

    private String password;

    public AuthCredentialRequestDto(){

    }

    public AuthCredentialRequestDto(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

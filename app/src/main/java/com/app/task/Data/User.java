package com.app.task.Data;

public class User {

    private String username;
    private String email;
    private String password;
    private String repassword;
    private String Phone;

    public User(String username,String email,String password,String repassword,String Phone){
        this.username=username;
        this.email=email;
        this.password=password;
        this.repassword=repassword;
        this.Phone=Phone;
    }
    public String getUsername(){
        return this.username;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getRepassword(){
        return this.repassword;
    }

    public String getPhone(){
        return this.Phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

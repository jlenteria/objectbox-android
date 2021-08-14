package com.rd.asynchttpclient.AsyncHttpClient.model;

import java.io.Serializable;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class SampleModel {
    @Id
    long id;

    private String username;
    private String firstName;
    private String lastName;
    private String status;
    private String password;

    public void setUsername(String uname){this.username = uname;}
    public  String getUsername(){return this.username;}
    public void setFirstName(String fname){this.firstName = fname;}
    public String getFirstName(){return  this.firstName;}
    public void setLastName(String lname){this.lastName = lname;}
    public String getLastName(){return this.lastName;}
    public  void setStatus(String status){this.status = status;}
    public String getStatus(){return this.status;}
    public void setPassword(String pass){this.password = pass;}
    public String getPassword(){return this.password;}

}

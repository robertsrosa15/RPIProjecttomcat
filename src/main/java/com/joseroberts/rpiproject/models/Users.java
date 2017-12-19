package com.joseroberts.rpiproject.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "users")
public class Users {
    @Id
    private String id;

    @NotNull
    @Size(min = 3)
    private String username;

    @NotNull
    @Size(min = 2)
    private String password;

    public Users(){}

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}

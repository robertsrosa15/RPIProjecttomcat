package com.joseroberts.rpiproject.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

//@Document(collection = "usersettings")
public class UserSettings {
    @Id
    private int id;

    private String person;

    private boolean approved;

    private ArrayList<String> settings;

    public UserSettings(String person, boolean approved) {
        this.person = person;
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}

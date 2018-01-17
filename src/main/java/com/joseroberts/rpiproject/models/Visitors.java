package com.joseroberts.rpiproject.models;

import org.springframework.data.annotation.Id;

//@Document(collection = "visitors")
public class Visitors {
    @Id
    private String id;
    private String visitorName;
    private String connection;
    private String permissions;
    private String photo;

    public Visitors(){}

    public Visitors(String visitorName, String connection, String permissions) {
        this.visitorName = visitorName;
        this.connection = connection;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @Override
    public String toString() {
        return "Visitors [id=" + id + ", visitorName=" + visitorName + ", connection=" + connection + ", permissions=" + permissions + "]";
    }
}

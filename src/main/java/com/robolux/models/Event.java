package com.robolux.models;

import java.util.Date;

public class Event {
    private int id;
    private String name;
    private String date;
    private String location;
    private int registered_count;

    // Constructors
    public Event() {
    }

    public Event(int id, String name, String date, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRegistered_count() {
        return registered_count;
    }

    public void setRegistered_count(int registered_count) {
        this.registered_count = registered_count;
    }

    // toString method for debugging/logging
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", registered_count=" + registered_count +
                '}';
    }
}

package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    private int id;
    private String name;
    private int phoneNumber;
    private String eventType;

    @Override
    public String toString() {
        return "" + name + "," +"" + phoneNumber ;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String toString1() {
        return ""+id+"," + name + "," +"" + phoneNumber ;
    }

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

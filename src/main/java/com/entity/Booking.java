package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "REQUIRED")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String date;
    @NotBlank(message = "REQUIRED")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private String time;
    private int numberOfPeople;
    @NotNull(message = "REQUIRED")
    private int clientId;

    public Booking() {
    }

    public Booking(int id, String date, String time, int numberOfPeople, int clientId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.numberOfPeople = numberOfPeople;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public int getClientId() {
        return clientId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

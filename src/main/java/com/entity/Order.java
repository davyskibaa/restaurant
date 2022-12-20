package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "REQUIRED")
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private String startTime;

    @NotBlank(message = "REQUIRED")
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private String endTime;

    @NotNull(message = "REQUIRED")
    private int bookingId;

    public Order() {
    }

    public Order(String startTime, String endTime, int bookingId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingId = bookingId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String format(LocalDateTime value) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(value);
    }
}

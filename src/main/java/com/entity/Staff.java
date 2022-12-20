package com.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="staff")
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "REQUIRED")
    private String first_name;
    @NotBlank(message = "REQUIRED")
    private String last_name;
    @NotBlank(message = "REQUIRED")
    private String passport;
    @NotBlank(message = "REQUIRED")
    private String job;
    public Staff() {
    }

    public Staff(int id, String first_name, String last_name, String passport, String job) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.passport = passport;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public String getJob() {
        return job;
    }
}

package com.ur.popbackend.entities;

import com.ur.popbackend.enums.Availability;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.TimeZone;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDate companyAniversary;
    private TimeZone timeZone;
    private Availability availability;
    private String phone;
    private LocalDate startingDate;
    private String companyRole;

    public Member() {
        //spring data
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

    public LocalDate getCompanyAniversary() {
        return companyAniversary;
    }

    public void setCompanyAniversary(LocalDate companyAniversary) {
        this.companyAniversary = companyAniversary;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public String getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole;
    }
}

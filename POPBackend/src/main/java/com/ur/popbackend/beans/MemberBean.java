package com.ur.popbackend.beans;

import com.ur.popbackend.enums.Availability;

import java.util.TimeZone;


public class MemberBean {
    private int id;
    private String name;
    private String companyAnniversary;
    private TimeZone timeZone;
    private Availability availability;
    private String phone;
    private String startingDate;
    private String companyRole;



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

    public String getCompanyAnniversary() {
        return companyAnniversary;
    }

    public void setCompanyAnniversary(String companyAnniversary) {
        this.companyAnniversary = companyAnniversary;
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

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole;
    }
}

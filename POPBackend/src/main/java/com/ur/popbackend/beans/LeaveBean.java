package com.ur.popbackend.beans;

import java.time.LocalDate;

public class LeaveBean {
    private int id;
    private LocalDate date;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private int duration;
    private String status;
    private String reason;
    private MemberBean Member;

    public LeaveBean(int id, LocalDate date, LocalDate startingDate, LocalDate endingDate, int duration, String status, String reason, MemberBean member) {
        this.id = id;
        this.date = date;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.duration = duration;
        this.status = status;
        this.reason = reason;
        Member = member;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public MemberBean getMember() {
        return Member;
    }

    public void setMember(MemberBean member) {
        Member = member;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

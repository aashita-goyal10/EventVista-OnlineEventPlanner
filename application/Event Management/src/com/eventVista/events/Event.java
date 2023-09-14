package com.eventVista.events;

import java.sql.Date;

public class Event {
    private int eventId,userId,vendorId,no_of_People;
    private String eventName,vendorName,venue;
    private double cost;
    private Date date;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Event(int eventId, int userId, int vendorId, int no_of_People, String eventName, String vendorName, String venue, double cost, Date date) {
        this.eventId = eventId;
        this.userId = userId;
        this.vendorId = vendorId;
        this.no_of_People = no_of_People;
        this.eventName = eventName;
        this.vendorName = vendorName;
        this.venue = venue;
        this.cost = cost;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }


    public int getNo_of_People() {
        return no_of_People;
    }

    public void setNo_of_People(int no_of_People) {
        this.no_of_People = no_of_People;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

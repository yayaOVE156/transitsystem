package com.example.transit_system;

import java.util.Date;

public class Hotel implements Booking{
    String hotel_name;
    float hotel_rate;
    double hotel_price;

    public Hotel(String name, float rating, double price_per_night){
        hotel_name =  name;
        hotel_rate = rating;
        hotel_price = price_per_night;
    }

    @Override
    public int getBookingId() {
        return 0;
    }
    @Override
    public Date getBookingDate() {
        return null;
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public boolean PaymentConfirmation(User user) {
        return false;
    }

    public String getType()
    {
        return "This is a hotel";
    }
}

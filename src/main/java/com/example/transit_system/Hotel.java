package com.example.transit_system;

import java.util.Date;

public class Hotel implements Booking{
    String hotel_name;
    float hotel_rate;
    double hotel_price;

    public Hotel(){}
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
    public void setPrice(double price) {

    }

    @Override
    public boolean PaymentConfirmation(User user) {
        return false;
    }

    public String getType()
    {
        return "hotel";
    }

    public void setHotel_name(String name){hotel_name = name;}
    public String getHotel_name(){return hotel_name;}
    public void setHotel_rate(float rate)
    {
        hotel_rate = rate;
    }
    public float getHotel_rate(){
        return hotel_rate;
    }
    public void setHotel_price(double price)
    {
        hotel_price = price;
    }
    public double getHotel_price(){
        return hotel_price;
    }

}

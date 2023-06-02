package com.example.transit_system;

import java.util.Date;

public class Plane extends Transportation{

    int flightNumber;
    Plane(int id, Date dt, Date at, String dep, String arr, int aop, int num) {
        super(id, dt, at, dep, arr, aop);
        flightNumber = num;

    }
    @Override
    public void setPrice(double price) {

    }

    @Override
    public boolean PaymentConfirmation(User user) {
        return false;
    }

    public int getFlightNumber()
    {
        return flightNumber;
    }
    public void setFlightNumber(int num)
    {
        flightNumber = num;
    }
    public String getType()
    {
        return "This is a Plane";
    }
}

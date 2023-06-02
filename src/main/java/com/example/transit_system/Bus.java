package com.example.transit_system;

import java.util.Date;

public class Bus extends Transportation{
    int busNumber;
    public Bus(int id, Date dt, Date at, String dep, String arr, int aop, int num) {
        super(id, dt, at, dep, arr, aop);
        busNumber = num;

    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public boolean PaymentConfirmation(User user) {
        return false;
    }

    @Override
    public String getType() {
        return null;
    }
    public void setBusNumber(int num)
    {
        busNumber = num;
    }
    public int getBusNumber()
    {
        return busNumber;
    }
}

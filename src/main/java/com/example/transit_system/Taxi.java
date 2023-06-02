package com.example.transit_system;

import java.util.Date;


public class Taxi extends Transportation{
    String licensePlate;
    Taxi(int id, Date dt, Date at, String dep, String arr, int aop, String num) {
        super(id, dt, at, dep, arr, aop);
        licensePlate = num;
    }
    @Override
    public String getType() {
        return "This is a Taxi";
    }
    @Override
    public void setPrice(double price) {

    }

    @Override
    public boolean PaymentConfirmation(User user) {
        return false;
    }
    public void setLicensePlate(String num)

public class Taxi extends Transportation {

    Taxi(){}
    Taxi(int id, Date dt, Date at, String dep, String arr, int aop)
    {
        licensePlate = num;
    }
}

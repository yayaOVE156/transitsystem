package com.example.transit_system;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


public class Taxi extends Transportation{
    String licensePlate;
    public Taxi(){}
    public Taxi(int id, Date dt, Date at, String dep, String arr, int aop, String num) {
        super(id, dt, at, dep, arr, aop);
        licensePlate = num;
    }
    @Override
    public String getType() {
        return "This is a Taxi";
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
    public void setLicensePlate(String num)
    {
        licensePlate = num;

    }
    public String getLicensePlate()
    {
        return licensePlate;
    }


}

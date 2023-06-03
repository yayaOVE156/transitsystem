package com.example.transit_system;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Plane extends Transportation{

    public Plane(){}
    public Plane(int id, Date dt, Date at, String dep, String arr, int aop, String name, double price) {
        super(id, dt, at, dep, arr, aop, name, price);

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
        return "Plane";
    }
}

package com.example.transit_system;

import java.util.Date;

public class Train extends Transportation{

    public Train(){}
    public Train(int id, Date dt, Date at, String dep, String arr, int aop)
    {
        super(id, dt, at, dep, arr, aop);
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

    @Override
    public String getType()
    {
        return "Train";
    }

}

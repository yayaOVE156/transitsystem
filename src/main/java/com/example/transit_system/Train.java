package com.example.transit_system;

import java.util.Date;

public class Train extends Transportation{
    int trainNumber;
    Train(int id, Date dt, Date at, String dep, String arr, int aop, int num)
    {
        super(id, dt, at, dep, arr, aop);
        trainNumber = num;
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
        return "this is a Train";
    }

    public int getTrainNumber()
    {
        return trainNumber;
    }
    public void setTrainNumber(int num)
    {
        trainNumber = num;
    }
}

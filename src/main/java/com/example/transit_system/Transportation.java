package com.example.transit_system;

import java.util.Date;

public class Transportation {
    int id;
    Date DepTime;
    Date ArrivalTime;
    String DepFrom;
    String ArrivalTo;
    int AmountOfPassengers;


    Transportation(int id, Date dt, Date at, String df, String ato, int aop){
        this.id = id;
        DepTime = dt;
        ArrivalTime = at;
        DepFrom = df;
        ArrivalTo = ato;
        AmountOfPassengers = aop;
    }
    public void setId(int ID)
    {
        id = ID;
    }
    public int getId()
    {
        return id;
    }

    public void setDepFrom(String depfrom)
    {
        DepFrom = depfrom;
    }
    public String getDepFrom()
    {
        return DepFrom;
    }
    public void setDepTime(Date time)
    {
        DepTime = time;
    }
    public Date getDepTime()
    {
        return DepTime;
    }
    public void setArrivalTo(String dest)
    {
        ArrivalTo = dest;
    }
    public String getArrivalTo()
    {
        return ArrivalTo;
    }
    public void setArrivalTime(Date time)
    {
        ArrivalTime = time;
    }
    public Date getArrivalTime()
    {
        return ArrivalTime;
    }

    public void setAmountOfPassengers(int amount)
    {
        AmountOfPassengers = amount;
    }
    public int getAmountOfPassengers()
    {
        return AmountOfPassengers;
    }


}

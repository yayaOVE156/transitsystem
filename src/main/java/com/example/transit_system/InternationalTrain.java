package com.example.transit_system;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class InternationalTrain extends Train {

    InternationalTrain(){}
    InternationalTrain(int id, Date dt, Date at, String dep, String arr, int aop, String name, double price)
    {
        super(id, dt, at, dep, arr, aop, name, price);
    }
}

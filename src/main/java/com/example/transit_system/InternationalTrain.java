package com.example.transit_system;

import java.util.Date;

public class InternationalTrain extends Train {
    InternationalTrain(int id, Date dt, Date at, String dep, String arr, int aop, int num)
    {
        super(id, dt, at, dep, arr, aop, num);
    }
}

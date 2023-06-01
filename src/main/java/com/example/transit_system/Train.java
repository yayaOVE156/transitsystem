package com.example.transit_system;

import java.util.Date;

public class Train extends Transportation {
    Train(int id, Date dt, Date at, String dep, String arr, int aop)
    {
        super(id, dt, at, dep, arr, aop);
    }
}

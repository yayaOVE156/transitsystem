package com.example.transit_system;

import java.util.Date;

public class Plane extends Transportation{
    Plane(int id, Date dt, Date at, String dep, String arr, int aop)
    {
        super(id, dt, at, dep, arr, aop);
    }

}

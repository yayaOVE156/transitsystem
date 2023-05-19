package com.example.transit_system;

import java.util.Date;

public class Feedback {

    int Id;
    String Name;
    String Message;
    Date Date;


    public int getId()
    {
        return Id;
    }
    public String getUser()
    {
        return Name;
    }
    public String getMessage()
    {
        return Message;
    }
    public Date getTimeStamp()
    {
        return Date;
    }
    public void setName(String n)
    {
        Name = n;
    }
    public void setMessage(String m)
    {
        Message = m;
    }

}

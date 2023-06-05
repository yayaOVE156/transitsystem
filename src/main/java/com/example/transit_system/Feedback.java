package com.example.transit_system;

import java.util.Date;

public class Feedback  {

    int Id;
    String Name;
    String Message;
    Date Date;
    Feedback(){}
    Feedback(String Msg){
        this.Message = Msg;
    }
    Feedback(int ID,String Name,String Msg,Date Date){
        this.Message = Msg;
        this.Name = Name;
        this.Id = ID;
        this.Date = Date;
    }

    public int getId()
    {
        return Id;
    }
    public void setId(int id) { Id = id;}
    public String getName()
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

    @Override
    public String toString() {
        return "ID:     "+ getId()+ " Name:      "+getName() + " Message:    " + getMessage()+" Date:    "+ getTimeStamp();
    }
}

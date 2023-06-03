package com.example.transit_system;

public class Ticket {
    Ticket(){}

    Ticket(float price, int transportationid, Item item)
    {
        Price = price;
        TransportationID = transportationid;
        this.item = item;
    }
    float Price;
    int TransportationID;

    Item item;

    public void setPrice(float price) {
        Price = price;
    }

    public void setTransportationID(int transportationID) {
        TransportationID = transportationID;
    }

    public int getTransportationID() {
        return TransportationID;
    }

    public float getPrice() {
        return Price;
    }
}

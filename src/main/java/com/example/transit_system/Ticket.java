package com.example.transit_system;

import java.util.List;

public class Ticket {
    Ticket(){}
    List<Item> ListOfItems;
    static int TicketID;

    Ticket(double price, int transportationid, Item item)
    {
        Price = price;
        TransportationID = transportationid;
        this.item = item;
    }
    double Price;
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

    public double getPrice() {
        return Price;
    }
}

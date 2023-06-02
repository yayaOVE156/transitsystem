package com.example.transit_system;

import java.util.Date;

public interface Booking {
    int getBookingId();
    Date getBookingDate();
    void setPrice(double price);
    boolean PaymentConfirmation(User user);
}

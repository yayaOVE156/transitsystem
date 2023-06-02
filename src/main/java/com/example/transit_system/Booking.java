package com.example.transit_system;

import java.util.Date;

public interface Booking {
    int getBookingId();
    Date getBookingDate();
    boolean makePayment();
}

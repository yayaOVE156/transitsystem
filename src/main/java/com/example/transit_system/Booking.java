package com.example.transit_system;

import java.util.Date;

public interface Booking {
    int getBookingId();
    Users getUser();
    Flight getFlight();
    Date getBookingDate();
    String getPaymentStatus();
    Double getPaymentAmount();
    boolean makePayment();
}

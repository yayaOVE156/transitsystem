package com.example.transit_system;

import java.util.HashMap;
import java.util.Map;

// Class representing the Booking System
public class BookingManager {

    // Map to store bookings (key: booking ID, value: booking details)
    private Map<String, Booking> bookings;

    // Constructor to initialize the BookingSystem
    public BookingManager() {
        bookings = new HashMap<>();
    }

    // Method to add a new booking
    public void addBooking(String bookingId, String customerId, int numOfTickets) {
        // Check if the booking ID already exists
        if (bookings.containsKey(bookingId)) {
            System.out.println("Booking ID already exists. Please choose a different ID.");
            return;
        }
        // Create a new Booking object and add it to the bookings map
        Booking newBooking = new Booking(bookingId, customerId, numOfTickets);
        bookings.put(bookingId, newBooking);
        System.out.println("Booking added successfully: " + newBooking);
    }

    // Method to cancel a booking
    public void cancelBooking(String bookingId) {
        // Check if the booking ID exists
        if (bookings.containsKey(bookingId)) {
            // Remove the booking from the bookings map
            Booking cancelledBooking = bookings.remove(bookingId);
            System.out.println("Booking cancelled: " + cancelledBooking);
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    // Method to retrieve details of a specific booking
    public void getBookingDetails(String bookingId) {
        // Check if the booking ID exists
        if (bookings.containsKey(bookingId)) {
            Booking booking = bookings.get(bookingId);
            System.out.println("Booking details: " + booking);
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    // Class representing a Booking
    private class Booking {
        private String bookingId;
        private String customerId;
        private int numOfTickets;

        // Constructor to initialize a Booking
        public Booking(String bookingId, String customerId, int numOfTickets) {
            this.bookingId = bookingId;
            this.customerId = customerId;
            this.numOfTickets = numOfTickets;
        }

        // Override toString() to provide a string representation of the Booking object
        @Override
        public String toString() {
            return "Booking ID: " + bookingId +
                    ", Customer ID: " + customerId +
                    ", Number of Tickets: " + numOfTickets;
        }
    }

    // Main method to test the BookingSystem class
    public static void main(String[] args) {
        BookingManager bookingSystem = new BookingManager();
        bookingSystem.addBooking("B001", "C001", 5);
        bookingSystem.addBooking("B002", "C002", 3);
        bookingSystem.getBookingDetails("B001");
        bookingSystem.cancelBooking("B002");
        bookingSystem.getBookingDetails("B002");
    }
}
//import java.util.HashMap;
//        import java.util.Map;
//
//// Abstract class representing a Transportation option
//abstract class Transportation {
//    private String id;
//    private String departure;
//    private String destination;
//
//    // Constructor for the Transportation class
//    public Transportation(String id, String departure, String destination) {
//        this.id = id;
//        this.departure = departure;
//        this.destination = destination;
//    }
//
//    // Abstract method to get the type of transportation
//    public abstract String getType();
//
//    // Getters for the attributes
//    public String getId() {
//        return id;
//    }
//
//    public String getDeparture() {
//        return departure;
//    }
//
//    public String getDestination() {
//        return destination;
//    }
//}
//
//// Derived class representing Plane transportation
//class Plane extends Transportation {
//    private int flightNumber;
//
//    // Constructor for the Plane class
//    public Plane(String id, String departure, String destination, int flightNumber) {
//        super(id, departure, destination);
//        this.flightNumber = flightNumber;
//    }
//
//    // Implementation of the abstract method
//    public String getType() {
//        return "Plane";
//    }
//
//    // Getter for the flight number
//    public int getFlightNumber() {
//        return flightNumber;
//    }
//}
//
//// Derived class representing Train transportation
//class Train extends Transportation {
//    private String trainNumber;
//
//    // Constructor for the Train class
//    public Train(String id, String departure, String destination, String trainNumber) {
//        super(id, departure, destination);
//        this.trainNumber = trainNumber;
//    }
//
//    // Implementation of the abstract method
//    public String getType() {
//        return "Train";
//    }
//
//    // Getter for the train number
//    public String getTrainNumber() {
//        return trainNumber;
//    }
//}
//
//// Derived class representing Bus transportation
//class Bus extends Transportation {
//    private String busNumber;
//
//    // Constructor for the Bus class
//    public Bus(String id, String departure, String destination, String busNumber) {
//        super(id, departure, destination);
//        this.busNumber = busNumber;
//    }
//
//    // Implementation of the abstract method
//    public String getType() {
//        return "Bus";
//    }
//
//    // Getter for the bus number
//    public String getBusNumber() {
//        return busNumber;
//    }
//}
//
//// Derived class representing Taxi transportation
//class Taxi extends Transportation {
//    private String licensePlate;
//
//    // Constructor for the Taxi class
//    public Taxi(String id, String departure, String destination, String licensePlate) {
//        super(id, departure, destination);
//        this.licensePlate = licensePlate;
//    }
//
//    // Implementation of the abstract method
//    public String getType() {
//        return "Taxi";
//    }
//
//    // Getter for the license plate
//    public String getLicensePlate() {
//        return licensePlate;
//    }
//}
//
//// Class representing the Booking System
//public class BookingSystem {
//    private Map<String, Transportation> bookings;
//
//    // Constructor to initialize the BookingSystem
//    public BookingSystem() {
//        bookings = new HashMap<>();
//    }
//
//    // Method to add a new booking
//    public void addBooking(String bookingId, Transportation transportation) {
//        // Check if the booking ID already exists
//        if (bookings.containsKey(bookingId)) {
//            System.out.println("Booking ID already exists. Please choose a different ID.");
//            return;
//        }
//        // Add the booking to the bookings map
//        bookings.put(bookingId, transportation);
//        System.out.println("Booking added successfully: " + transportation.getType() + " - " + transportation.getId());
//    }
//
//    // Method to cancel a booking
//    public void cancelBooking(String bookingId) {
//        // Check if the booking ID exists
//        if (bookings.containsKey(bookingId)) {
//            // Remove the booking from the bookings map
//            Transportation cancelledBooking = bookings.remove(bookingId);
//            System.out.println("Booking cancelled: " + cancelledBooking.getType() + " - " + cancelledBooking.getId());
//        } else {
//            System.out.println("Booking ID not found.");
//        }
//    }
//
//    // Method to retrieve details of a specific booking
//    public void getBookingDetails(String bookingId) {
//        // Check if the booking ID exists
//        if (bookings.containsKey(bookingId)) {
//            Transportation transportation = bookings.get(bookingId);
//            System.out.println("Booking details: " + transportation.getType() + " - " + transportation.getId());
//            System.out.println("Departure: " + transportation.getDeparture());
//            System.out.println("Destination: " + transportation.getDestination());
//            if (transportation instanceof Plane) {
//                Plane plane = (Plane) transportation;
//                System.out.println("Flight Number: " + plane.getFlightNumber());
//            } else if (transportation instanceof Train) {
//                Train train = (Train) transportation;
//                System.out.println("Train Number: " + train.getTrainNumber());
//            } else if (transportation instanceof Bus) {
//                Bus bus = (Bus) transportation;
//                System.out.println("Bus Number: " + bus.getBusNumber());
//            } else if (transportation instanceof Taxi) {
//                Taxi taxi = (Taxi) transportation;
//                System.out.println("License Plate: " + taxi.getLicensePlate());
//            }
//        } else {
//            System.out.println("Booking ID not found.");
//        }
//    }
//
//    // Main method to test the BookingSystem class
//    public static void main(String[] args) {
//        BookingSystem bookingSystem = new BookingSystem();
//
//        Plane plane = new Plane("P001", "City A", "City B", 123);
//        Train train = new Train("T001", "City C", "City D", "ABC123");
//        Bus bus = new Bus("B001", "City X", "City Y", "XYZ456");
//        Taxi taxi = new Taxi("T001", "City P", "City Q", "DEF789");
//
//        bookingSystem.addBooking("B001", plane);
//        bookingSystem.addBooking("B002", train);
//        bookingSystem.addBooking("B003", bus);
//        bookingSystem.addBooking("B004", taxi);
//
//        bookingSystem.getBookingDetails("B001");
//        bookingSystem.getBookingDetails("B002");
//        bookingSystem.getBookingDetails("B003");
//        bookingSystem.getBookingDetails("B004");
//
//        bookingSystem.cancelBooking("B002");
//        bookingSystem.getBookingDetails("B002");
//    }
//}
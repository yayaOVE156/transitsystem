package com.example.transit_system;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Class representing the Register Manager
public class RegisterManager {
    private Map<String, String> userCredentials;

    // Constructor to initialize the RegisterManager
    public RegisterManager() {
        userCredentials = new HashMap<>();
    }

    // Method to register a new user
    public void registerUser(String username, String password, String confirmPassword, String email,
                             String address, String phoneNumber, String country) {
        // Check if the username is already taken
        if (userCredentials.containsKey(username)) {
            System.out.println("Username already taken. Please choose a different username.");
            return;
        }

        // Check if the password and confirmed password match
        if (!password.equals(confirmPassword)) {
            System.out.println("Password and confirmed password do not match.");
            return;
        }

        // Check if the email is valid
        if (!isValidEmail(email)) {
            System.out.println("Invalid email address.");
            return;
        }

        // Check if the phone number is valid
        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number.");
            return;
        }

        // Check if the country is valid
        if (!isValidCountry(country)) {
            System.out.println("Invalid country.");
            return;
        }

        // Add the user to the userCredentials map
        userCredentials.put(username, password);

        // Display the registration details
        System.out.println("User registered successfully:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Country: " + country);
    }

    // Method to check if a username is available
    public boolean isUsernameAvailable(String username) {
        return !userCredentials.containsKey(username);
    }

    // Method to validate an email address using regular expression
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to validate a phone number
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Remove any non-digit characters from the phone number
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");

        // Check if the remaining digits form a valid phone number
        return digitsOnly.matches("\\d{10}"); // Assuming a 10-digit phone number
    }

    // Method to validate a country
    private boolean isValidCountry(String country) {
        // List of valid countries
        String[] validCountries = { "Country A", "Country B", "Country C" }; // Add more valid countries as needed

        // Check if the country is present in the valid countries list
        for (String validCountry : validCountries) {
            if (validCountry.equalsIgnoreCase(country)) {
                return true;
            }
        }
        return false;
    }

    // Main method to test the RegisterManager class
    public static void main(String[] args) {
        RegisterManager registerManager = new RegisterManager();
        registerManager.registerUser("user1", "password1", "password1", "user1@example.com",
                "123 Main St, City, Country", "1234567890", "Country A");
        registerManager.registerUser("user2", "password2", "password3", "user2@example.com",
                "456 Elm St, City, Country", "9876543210", "Country D");
    }
}
//import javafx.scene.control.Alert;
//        import javafx.scene.control.Alert.AlertType;
//
//        import java.util.HashMap;
//        import java.util.Map;
//        import java.util.regex.Matcher;
//        import java.util.regex.Pattern;
//
//// Class representing the Register Manager
//public class RegisterManager {
//    private Map<String, String> userCredentials;
//
//    // Constructor to initialize the RegisterManager
//    public RegisterManager() {
//        userCredentials = new HashMap<>();
//    }
//
//    // Method to register a new user
//    public void registerUser(String username, String password, String confirmPassword, String email,
//                             String address, String phoneNumber, String country) {
//        try {
//            // Check if the username is already taken
//            if (userCredentials.containsKey(username)) {
//                throw new Exception("Username already taken. Please choose a different username.");
//            }
//
//            // Check if the password and confirmed password match
//            if (!password.equals(confirmPassword)) {
//                throw new Exception("Password and confirmed password do not match.");
//            }
//
//            // Check if the email is valid
//            if (!isValidEmail(email)) {
//                throw new Exception("Invalid email address.");
//            }
//
//            // Check if the phone number is valid
//            if (!isValidPhoneNumber(phoneNumber)) {
//                throw new Exception("Invalid phone number.");
//            }
//
//            // Check if the country is valid
//            if (!isValidCountry(country)) {
//                throw new Exception("Invalid country.");
//            }
//
//            // Add the user to the userCredentials map
//            userCredentials.put(username, password);
//
//            // Display the registration details
//            System.out.println("User registered successfully:");
//            System.out.println("Username: " + username);
//            System.out.println("Email: " + email);
//            System.out.println("Address: " + address);
//            System.out.println("Phone Number: " + phoneNumber);
//            System.out.println("Country: " + country);
//        } catch (Exception e) {
//            displayErrorMessage("Registration Failed", e.getMessage());
//        }
//    }
//
//    // Method to check if a username is available
//    public boolean isUsernameAvailable(String username) {
//        return !userCredentials.containsKey(username);
//    }
//
//    // Method to validate an email address using regular expression
//    private boolean isValidEmail(String email) {
//        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
//
//    // Method to validate a phone number
//    private boolean isValidPhoneNumber(String phoneNumber) {
//        // Remove any non-digit characters from the phone number
//        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
//
//        // Check if the remaining digits form a valid phone number
//        return digitsOnly.matches("\\d{10}"); // Assuming a 10-digit phone number
//    }
//
//    // Method to validate a country
//    private boolean isValidCountry(String country) {
//        // List of valid countries
//        String[] validCountries = { "Country A", "Country B", "Country C" }; // Add more valid countries as needed
//
//        // Check if the country is present in the valid countries list
//        for (String validCountry : validCountries) {
//            if (validCountry.equalsIgnoreCase(country)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Method to display an error message as a message box in the GUI
//    private void displayErrorMessage(String title, String message) {
//        Alert alert = new Alert(AlertType.ERROR);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
//    // Main method to test the RegisterManager class
//    public static void main(String[] args) {
//        RegisterManager registerManager = new RegisterManager();
//        registerManager.registerUser("user1", "password1", "password1", "user1@example.com",
//                "123 Main St, City, Country", "1234567890", "Country A");
//        registerManager.registerUser("user2", "password2", "password3", "user2@example.com",
//                "456 Elm St, City, Country", "9876543210", "Country D");
//    }
//}
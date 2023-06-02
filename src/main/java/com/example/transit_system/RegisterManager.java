package com.example.transit_system;

import java.util.HashMap;
import java.util.Map;

// Class representing the Register Manager
public class RegisterManager {
    private Map<String, String> userCredentials;

    // Constructor to initialize the RegisterManager
    public RegisterManager() {
        userCredentials = new HashMap<>();
    }

    // Method to register a new user
    public void registerUser(String username, String password) {
        // Check if the username is already taken
        if (userCredentials.containsKey(username)) {
            System.out.println("Username already taken. Please choose a different username.");
            return;
        }
        // Add the user to the userCredentials map
        userCredentials.put(username, password);
        System.out.println("User registered successfully: " + username);
    }

    // Method to check if a username is available
    public boolean isUsernameAvailable(String username) {
        return !userCredentials.containsKey(username);
    }

    // Main method to test the RegisterManager class
    public static void main(String[] args) {
        RegisterManager registerManager = new RegisterManager();
        registerManager.registerUser("user1", "password1");
        registerManager.registerUser("user2", "password2");
        boolean isUsernameAvailable = registerManager.isUsernameAvailable("user1");
        System.out.println("Username 'user1' is available: " + isUsernameAvailable);
        isUsernameAvailable = registerManager.isUsernameAvailable("user3");
        System.out.println("Username 'user3' is available: " + isUsernameAvailable);
    }
}
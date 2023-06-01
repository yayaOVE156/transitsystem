package com.example.transit_system;
import java.util.ArrayList;
import java.util.List;
// Class representing an item
class Item {
    private String name;
    private double price;

    // Constructor to initialize the item
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters for item properties
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
// Class representing the CheckOut Manager
public class CheckOutManager {
    private List<Item> cart;
    private double totalPrice;
    private double discount;
    private double tax;
    private int loyaltyPoints;

    // Constructor to initialize the CheckOut Manager
    public CheckOutManager() {
        cart = new ArrayList<>();
        totalPrice = 0.0;
        discount = 0.0;
        tax = 0.0;
        loyaltyPoints = 0;
    }

    // Method to add an item to the cart
    public void addItem(Item item) {
        cart.add(item);
        totalPrice += item.getPrice();
        System.out.println("Item added to the cart: " + item.getName());
    }

    // Method to remove an item from the cart
    public void removeItem(Item item) {
        if (cart.contains(item)) {
            cart.remove(item);
            totalPrice -= item.getPrice();
            System.out.println("Item removed from the cart: " + item.getName());
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    // Method to apply a discount to the total price
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            System.out.println("Invalid discount percentage.");
            return;
        }
        discount = totalPrice * (discountPercentage / 100);
        System.out.println("Discount applied: " + discount);
    }

    // Method to calculate the total price after applying discount and tax
    public double calculateTotalPrice() {
        double totalPriceAfterDiscount = totalPrice - discount;
        double totalPriceAfterTax = totalPriceAfterDiscount + (totalPriceAfterDiscount * (tax / 100));
        return totalPriceAfterTax;
    }

    // Method to process the payment using loyalty points
    public void processPaymentWithLoyaltyPoints(int pointsToUse) {
        if (pointsToUse <= loyaltyPoints) {
            double finalPrice = calculateTotalPrice();
            double amountPaidWithPoints = pointsToUse * 0.01; // Each loyalty point is worth $0.01
            double remainingAmount = finalPrice - amountPaidWithPoints;
            loyaltyPoints -= pointsToUse;

            if (remainingAmount > 0) {
                System.out.println("Insufficient loyalty points to cover the total amount. Please pay: $" + remainingAmount);
            } else {
                System.out.println("Payment processed successfully using " + pointsToUse + " loyalty points.");
                generateReceipt();
                clearCart();
            }
        } else {
            System.out.println("You don't have enough loyalty points to make the payment.");
        }
    }

    // Method to process the payment using a credit card
    public void processPaymentWithCreditCard(String cardNumber, String expiryDate, String cvv) {
        // Perform credit card validation and payment processing logic here
        double finalPrice = calculateTotalPrice();
        System.out.println("Payment processed successfully with credit card: " + cardNumber);
        generateReceipt();
        clearCart();
    }

    // Method to generate the checkout receipt
    public void generateReceipt() {
        System.out.println("Checkout Receipt:");
        for (Item item : cart) {
            System.out.println("Item: " + item.getName() + " - Price: " + item.getPrice());
        }
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + (totalPrice - discount) * (tax / 100));
        System.out.println("Final Price: " + calculateTotalPrice());
    }

    // Method to clear the cart after payment
    public void clearCart() {
        cart.clear();
        totalPrice = 0.0;
        discount = 0.0;
    }

    // Main method to test the CheckOutManager class
    public static void main(String[] args) {
        // Creating items for the checkout
        Item item1 = new Item("Hotel Room", 100.0);
        Item item2 = new Item("Meals", 50.0);
        Item item3 = new Item("Wi-Fi", 10.0);

        // Creating the CheckOutManager instance
        CheckOutManager checkOutManager = new CheckOutManager();

        // Adding items to the cart
        checkOutManager.addItem(item1);
        checkOutManager.addItem(item2);
        checkOutManager.addItem(item3);

        // Applying a discount
        checkOutManager.applyDiscount(10.0);

        // Calculating and displaying the total price
        double totalPrice = checkOutManager.calculateTotalPrice();
        System.out.println("Total Price: " + totalPrice);

        // Removing an item from the cart
        checkOutManager.removeItem(item2);

        // Processing the payment using loyalty points
        checkOutManager.processPaymentWithLoyaltyPoints(200);

        // Processing the payment with a credit card
        checkOutManager.processPaymentWithCreditCard("1234567890123456", "12/25", "123");
    }
}
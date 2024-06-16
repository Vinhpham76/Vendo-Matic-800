package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.logging.Level.parse;

public class InventoryManagement {
    private Map<String, Double> itemPrices;
    private Map<String, Integer> itemQuantities;
    private Map<String, String> itemLocations;
    private Map<String, String> itemType;

    public InventoryManagement() {
        itemPrices = new HashMap<>();
        itemQuantities = new HashMap<>();
        itemLocations = new HashMap<>();
        itemType = new HashMap<>();
        loadInventoryFromFile("vendingmachine.csv");
    }

    private void loadInventoryFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|"); // Split by pipe character
                if (parts.length == 4) {
                    String location = parts[0];
                    String itemName = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    String type = parts[3];
                    itemPrices.put(itemName, price);
                    itemLocations.put(itemName, location);
                    itemQuantities.put(itemName, 0); // Adds items to quantity list, defaults quantity to 0
                    itemType.put(itemName, type);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error loading inventory from file: " + e.getMessage());
        }
    }

    public void displayInventory() {
        for (Map.Entry<String, Double> entry : itemPrices.entrySet()) {
            String itemName = entry.getKey();
            double price = entry.getValue();
            int quantity = itemQuantities.getOrDefault(itemName, 0);
            String location = itemLocations.getOrDefault(itemName, "");
            System.out.println("[" + location + "]" + itemName + ": $" + price + " (" + quantity + " left)");
        }
    }

    public void addQuantity(String itemName, int quantityToAdd) {
        if (itemQuantities.containsKey(itemName)) {
            int currentQuantity = itemQuantities.get(itemName);
            int newQuantity = currentQuantity + quantityToAdd;
            itemQuantities.put(itemName, newQuantity);
            System.out.println("Added " + quantityToAdd + " to " + itemName);
        } else {
            System.out.println(itemName + " not found in inventory.");
        }
    }

    public void subtractQuantity(String itemName, int quantityToSubtract) {
        if (itemQuantities.containsKey(itemName)) {
            int currentQuantity = itemQuantities.get(itemName);
            if (currentQuantity >= quantityToSubtract) {
                int newQuantity = currentQuantity - quantityToSubtract;
                itemQuantities.put(itemName, newQuantity);
                if (newQuantity == 0) {
                    System.out.println(itemName + " is now SOLD OUT.");
                }
            } else {
                System.out.println("Not enough quantity available for " + itemName);
            }
        } else {
            System.out.println(itemName + " not found in inventory.");
        }
    }

    // Returns Item price given Item Name
    public double getItemPrice(String itemName) {
        return itemPrices.getOrDefault(itemName, 0.0);
    }

    // Returns Item location (i.e. A1, D2, B3) when given Item name
    public String getItemLocation(String itemName) {
        return itemLocations.getOrDefault(itemName, "N/A");
    }
    // Returns the quantity of an Item given the Item Name
    public int getItemQuantity(String itemName) {
        return itemQuantities.getOrDefault(itemName, 0);
    }

    // For testing purposes
    public static void main(String[] args) {
        InventoryManagement vendingMachine = new InventoryManagement();
//        vendingMachine.displayInventory();
//        vendingMachine.addQuantity("Potato Crisps", 5);
//        vendingMachine.addQuantity("U-Chews", 10);
//        vendingMachine.addQuantity("Dr. Salt", 10);
            vendingMachine.displayInventory();
//        System.out.println(vendingMachine.getItemLocation("Cola"));
//        System.out.println(vendingMachine.getItemQuantity("Cola"));
    }
}



package com.techelevator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private String inputFile;
    private static double balance;
    private Map<String, VendingItems> inventory = new HashMap<>();

    public VendingMachine(String inputFile)  {
        this.inputFile = inputFile;

        balance = 0.0;
    }




    public void displayItems() {
        for (VendingItems item : inventory.values()) {
            System.out.println(item.getSlotID() + ". " + item.getName() + ", $" + item.getPrice() + ", Qty:" + item.getQuantity());
        }
    }

    // Getters
    public static double getBalance() {
        return balance;
    }
}

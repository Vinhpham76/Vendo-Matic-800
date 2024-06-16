package com.techelevator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private String inputFile;
    private static double currentBalance;
    private Map<String, VendingItems> inventory = new HashMap<>();

    public VendingMachine(String inputFile)  {
        this.inputFile = inputFile;

        currentBalance = 0.0;
    }

    public void selectProduct(String slotID) {
        VendingItems product = inventory.get(slotID);
        if (product == null) {
            System.out.println("Invalid product ID.");
            return;
        }
        if (product.isSoldOut()) {
            System.out.println("Product is SOLD OUT.");
            return;
        }
        if (currentBalance < product.getPrice()) {
            System.out.println("Insufficient funds.");
            return;
        }


        currentBalance-= product.getPrice();
        System.out.printf("Dispensed: %s ($%.2f). Remaining balance: $%.2f\n", product.getName(), product.getPrice(), currentBalance);
        System.out.println(product.dispenseMessage());

    }



    public void displayItems() {
        for (VendingItems item : inventory.values()) {
            System.out.println(item.getSlotID() + ". " + item.getName() + ", $" + item.getPrice() + ", Qty:" + item.getQuantity());
        }
    }


}

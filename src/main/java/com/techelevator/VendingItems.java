package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class VendingItems {
    private String slotID;
    private String name;
    private double price;
    private String type;
    private int quantity;
    private final int MAX_QUANTITY = 5;

    public VendingItems(String slotID, String name, double price, String type) {
        this.slotID = slotID;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = MAX_QUANTITY;
    }

    // Getters
    public String getSlotID() {
        return slotID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // isSoldOut method.
    public boolean isSoldOut() {
        return quantity == 0;
    }

}

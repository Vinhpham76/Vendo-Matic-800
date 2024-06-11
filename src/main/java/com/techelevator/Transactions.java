package com.techelevator;

public class Transactions {
    private double currentBalance;


    public void Transactions() {
        this.currentBalance = 0.0;
    }
    //Feeding money into the machine method
    public void feedMoney(double amount){
        if (amount>0) {
            currentBalance += amount;
            System.out.printf("Added $%.2f to the machine. Current balance is $%.2f.%n", amount, currentBalance);
        }else {
            System.out.println("Invalid amount. Please add money");
        }
    }

    //Dispense change method
    public void dispenseChange(double amount) {
        if (amount > currentBalance) {
            System.out.println("insufficient balance to return requested amount.");
            return;
        }
        int[] currencyValue = {2000, 1000, 500, 100, 25, 10, 5, 1};//in cent values
        String[] currencyNames = {"$20 bills", "$10 bills", "$5 bills", "$1 bills", "quarters", "dimes", "nickles", "pennies"};

        // Convert amount to cents to avoid floating-point precision issues
        int remainingAmount = (int) Math.round(amount * 100);
        currentBalance -= amount;

        System.out.printf("Dispensing $%.2f in change:%n", amount);

        for (int i = 0; i < currencyValue.length; i++) {
            int count = remainingAmount / currencyValue[i];
            if (count > 0) {
                remainingAmount %= currencyValue[i];
                System.out.printf("%d %s%n", count, currencyNames[i]);
            }
        }
    }
    // Method to get the current balance
      public double getCurrentBalance(){
        return currentBalance;
    }
}
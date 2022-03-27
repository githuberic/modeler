package com.lgq.oop.practices.p1;

/**
 * @author lgq
 */
public class OrderItem {
    public String Name;
    public double Price;
    public int Quantity;
    public BillingStrategy Strategy;

    public OrderItem(String name, double price, int quantity, BillingStrategy strategy) {
        this.Name = name;
        this.Price = price;
        this.Quantity = quantity;
        this.Strategy = strategy;
    }
}

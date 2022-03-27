package com.lgq.oop.practices.p1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 */
public class Order {
    private List<OrderItem> orderItems = new ArrayList<>();
    private BillingStrategy strategy = new NormalStrategy();

    public void Add(String name, double price, int quantity, BillingStrategy strategy) {
        orderItems.add(new OrderItem(name, price, quantity, strategy));
    }
    
    // Payment of bill
    public void PayBill() {
        double sum = 0;
        for (OrderItem item : orderItems) {
            double actPrice = item.Strategy.getActPrice(item.Price * item.Price);
            sum += actPrice;

            System.out.println(String.format("%s -- %f(%d) - %f", item.Name, item.Price, item.Quantity, actPrice));
        }
        System.out.println("Total due: " + sum);
    }
}

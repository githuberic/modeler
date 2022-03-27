package com.lgq.oop.practices.p1;

/**
 * @author lgq
 */
public class HappyHourStrategy implements BillingStrategy {
    @Override
    public double getActPrice(double rawPrice) {
        return rawPrice * 0.5;
    }
}

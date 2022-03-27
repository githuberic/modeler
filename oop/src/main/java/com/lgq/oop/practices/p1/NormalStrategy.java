package com.lgq.oop.practices.p1;

/**
 * @author lgq
 */
public class NormalStrategy implements BillingStrategy {
    @Override
    public double getActPrice(double rawPrice) {
        return rawPrice;
    }
}

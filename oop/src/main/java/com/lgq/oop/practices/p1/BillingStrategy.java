package com.lgq.oop.practices.p1;

/**
 * @author lgq
 */
public interface BillingStrategy {
    /**
     * @param rawPrice
     * @return
     */
    double getActPrice(double rawPrice);
}

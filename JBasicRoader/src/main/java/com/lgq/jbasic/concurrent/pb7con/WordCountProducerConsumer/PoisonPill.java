package com.lgq.jbasic.concurrent.pb7con.WordCountProducerConsumer;

/**
 * @author lgq
 */
public class PoisonPill extends Page {
    @Override
    public boolean isPoisonPill() {
        return true;
    }
}

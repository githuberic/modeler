package com.lgq.multiplethread.pb7con.WordCountConcurrentHashMap;

/**
 * @author lgq
 */
abstract class Page {
    public String getTitle() {
        throw new UnsupportedOperationException();
    }

    public String getText() {
        throw new UnsupportedOperationException();
    }

    public boolean isPoisonPill() {
        return false;
    }
}
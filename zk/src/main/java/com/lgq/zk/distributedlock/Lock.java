package com.lgq.zk.distributedlock;

/**
 * @author lgq
 */
public interface Lock {
    boolean lock() throws Exception;

    boolean unlock();
}

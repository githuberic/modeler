package com.lgq.jbasic.pool.chapter01;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author lgq
 */
public class TestObjectPool extends GenericObjectPool<TestObject> {
    public TestObjectPool(PooledObjectFactory<TestObject> factory) {
        super(factory);
    }

    public TestObjectPool(PooledObjectFactory<TestObject> factory, GenericObjectPoolConfig<TestObject> config) {
        super(factory, config);
    }

    public TestObjectPool(PooledObjectFactory<TestObject> factory, GenericObjectPoolConfig<TestObject> config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}

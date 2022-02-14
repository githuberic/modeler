package com.lgq.jbasic.pool.chapter01;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author lgq
 */
public class TestObjectFactory implements PooledObjectFactory<TestObject> {
    /**
     * /构造一个封装对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public PooledObject<TestObject> makeObject() throws Exception {
        return new DefaultPooledObject<>(new TestObject());
    }

    /**
     * 销毁对象
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void destroyObject(PooledObject<TestObject> p) throws Exception {
        p.getObject().destroy();
    }

    /**
     * 验证对象是否可用
     *
     * @param p
     * @return
     */
    @Override
    public boolean validateObject(PooledObject<TestObject> p) {
        return p.getObject().isActive();
    }

    /**
     * 激活一个对象，使其可用用
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void activateObject(PooledObject<TestObject> p) throws Exception {
        p.getObject().setActive(true);
    }

    /**
     * 钝化一个对象,也可以理解为反初始化
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void passivateObject(PooledObject<TestObject> p) throws Exception {
    }
}

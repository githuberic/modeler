package com.lgq.jbasic.pool.chapter01.app;

import com.lgq.jbasic.pool.chapter01.TestObject;
import com.lgq.jbasic.pool.chapter01.TestObjectPool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lgq
 */
@Service
public class PoolService {
    @Resource
    private TestObjectPool testObjectPool;

    public void test() {
        TestObject testObject = null;
        try {
            testObject = testObjectPool.borrowObject();
            //省略业务代码...
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (testObject != null) {
                //最终归还对象到对象池
                testObjectPool.returnObject(testObject);
            }
        }
    }
}

package com.lgq.ds.extension.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 */
public class BFGuavaBasicTest {
    BloomFilter<Integer> bloomFilter;
    int size = 1_000_000;

    @Before
    public void setUp() {
        bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, 0.0003);
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }
    }

    @Test
    public void testBasic() {
        int containSize = 100;
        for (int i = 0; i < containSize; i++) {
            if (!bloomFilter.mightContain(i)) {
                System.out.println("有坏人逃脱了");
            }
        }

        List<Integer> list = new ArrayList<>(1000);
        for (int i = size + 10000; i < size + 20000; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }

        System.out.println("有误伤的数量：" + list.size());
    }
}

package com.lgq.ds.bit.practice.pmissingduplicate;

import org.junit.Test;

/**
 * @author lgq
 */
public class MissingDuplicateTest {
    @Test
    public void testMissingDuplicate() {
        int[] A = {2, 1, 3, 5, 5, 3, 2, 1, 6, 7, 7, 8, 8};
        MissingDuplicate i = new MissingDuplicate();
        System.out.println("Missing duplicate is " + i.find(A));
    }
}

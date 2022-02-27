package com.lgq.ds.array.v1;


import org.junit.Test;

/**
 * @author lgq
 */
public class GenericArrayTest {

    @Test
    public void testBasic() {
        GenericArray<Integer> genericArray = new GenericArray<>(3);
        genericArray.add(3, 0);
        genericArray.add(22, 1);
        genericArray.add(9, 2);
        genericArray.add(8, 3);
        genericArray.add(5, 4);
        System.out.println(genericArray.toString());
        System.out.println(">>>remove");
        genericArray.remove(2);
        System.out.println(genericArray.toString());
        genericArray.add(44, 2);
        int findPosition = genericArray.find(44);
        System.out.println(String.format(">>>find,element=%s,position=%d\n", 44, findPosition));
    }
}

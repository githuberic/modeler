package com.lgq.jbasic.steam.examples.e2;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author lgq
 */
public class StremTest {
    @Test
    public void testMap() {
        Stream.of("a", "b", "hi").map(p -> p.toUpperCase()).forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        Stream.of(1, 2, 3).flatMap(p -> Stream.of(p * 10)).forEach(System.out::println);
    }

    @Test
    public void testPeek() {
        Stream.of(1, 2, 3).peek(p -> System.out.println("peek:" + p)).forEach(System.out::println);
    }
}

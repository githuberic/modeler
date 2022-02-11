package com.lgq.jbasic.steam.examples.e1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author lgq
 */
public class App {
    List<String> lines = null;
    List<Person> persons = null;

    @Before
    public void setUp() {
        lines = Arrays.asList("spring", "node", "mkyong");

        persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );
    }

    @Test
    public void testForEach() {
        List<String> result = lines.stream()
                .filter(line -> !"mkyong".equals(line))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testFilter() {
        Person person = persons.stream()
                .filter(item -> "jack".equals(item.getName()))
                .findAny()
                .orElse(null);
        System.out.println(person);
    }

    @Test
    public void testFilterFun() {
        Person person = persons.stream().filter(p -> {
            if ("jack".equalsIgnoreCase(p.getName()) && p.getAge() == 20) {
                return true;
            }
            return false;
        }).findAny().orElse(null);
        System.out.println(person);
    }

    @Test
    public void testFilterAndMap() {
        String name = persons.stream().map(Person::getName).filter(
                "jack"::equalsIgnoreCase
        ).findAny().orElse(null);
        System.out.println(name);
    }

    @Test
    public void testFilterMap() {
        Random random = new Random();
        List<Student> students = persons.stream()
                .filter(p -> p.getAge() > 18)
                .map(person -> new Student(random.nextInt(), person))
                .collect(Collectors.toList());
        students.forEach(System.out::println);
    }

    @Test
    public void testFilterMapE2() {
        final int[] id = {1};
        List<Student> students = persons.stream()
                .filter(p -> p.getAge() > 18)
                .map(p -> new Student(id[0]++, p))
                .collect(Collectors.toList());
        students.forEach(System.out::println);
    }
}

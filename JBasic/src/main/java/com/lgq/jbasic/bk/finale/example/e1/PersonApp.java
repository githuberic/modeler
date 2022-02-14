package com.lgq.jbasic.bk.finale.example.e1;

/**
 * @author lgq
 */
public class PersonApp {

    private final static Person person = new Person("lisi", 20);

    public static void main(String[] args) {
        person.age = 25;
        System.out.println(person.toString());
    }

    static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

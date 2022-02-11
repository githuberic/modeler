package com.lgq.jbasic.steam.examples.e1;

/**
 * @author lgq
 */
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String toString(){
        return "name=" + name + ", age=" + age;
    }
}

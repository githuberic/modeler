package com.lgq.jbasic.steam.examples.e1;

/**
 * @author lgq
 */
public class Student {
    private int id;
    private Person person;

    public Student(Person person){
        this.person = person;
    }

    public Student(int id,Person person){
        this.id = id;
        this.person = person;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "id=" + id + ", "+this.person.toString();
    }
}

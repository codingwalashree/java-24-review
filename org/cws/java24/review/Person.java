package org.cws.java24.review;

public class Person {
    private String name;
    private double age;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println("\n Prologue in Person"); // prologue
        this("unknown", 0.0);
    }
}

class Student extends Person {
    private long rollNumber;

    public Student(String name, double age, long rollNumber) {
        System.out.println("\n Prologue in Student"); // prologue
        super(name, age);
        this.rollNumber = rollNumber;
    }
}



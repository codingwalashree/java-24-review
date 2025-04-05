package org.cws.java24.review;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

// Compile: javac --enable-preview --release 24 .\org\cws\java24\review\Java24FeaturesDemo.java
// Run: java --enable-preview -cp . "org/cws/java24/review/Java24FeaturesDemo"  Java24FeaturesDemo
public class Java24FeaturesDemo {
    public void main() {
        System.out.println("Hello from Java 24!");

//        Object value = 20;
//        System.out.println((int)value * 2);
//        if(value instanceof int i) {
//            System.out.println("After pattern matching in instanceof i * 2 =" + i * 2);
//        }
        Object[] testValues = {
                10,
                11.11,
                "Hello",
                new Book("book 1", "author 1", 299)
        };
        for (Object value: testValues) {
            System.out.println("---------------------");
            patternMatchingDemo(value);
        }

        flexibleConstructorBodiesDemo();
        streamGathererDemo();
    }

    public static void streamGathererDemo() {
        System.out.println("Stream gather demo - Gatherers.windowFixed()");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .gather(Gatherers.windowFixed(3))
                .toList()
                .forEach(System.out::println);

        System.out.println("Stream gather demo - Gatherers.windowSliding()");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .gather(Gatherers.windowSliding(3))
                .toList()
                .forEach(System.out::println);
    }

    /**
     * Demo of Flexible Constructor Bodies
     * */
    public static void flexibleConstructorBodiesDemo() {
        new Student("ABC", 10.3, 123);
        new Person("ABC", 10.3);
        new Person();
    }

    /** 
     * JEP 488: Pattern Matching with Primitive Types
     * 
     * Pattern matching - instanceof with Primitive Types
     * Pattern matching - instanceof with records
     * Pattern matching - switch with Primitive Types
     */
    public static void patternMatchingDemo(Object value) {
        if (value instanceof int i) {
            System.out.println("Detected type int: " + i);
        } else if (value instanceof double d) {
            System.out.println("Detected type double: " + d);
        }

        else if (value instanceof String s) { // reference type matching
            System.out.println("Detected value is of type String: " + s);
        }
        else if (value instanceof Book book) { // with records
            System.out.println("Detected value is of type Book: " + book);
        }

        // 3. Pattern matching - switch with Primitive Types
        switch (value) {
            case int i -> System.out.println("switch detected int: " + i);
            case double d when d < 1.0 -> {
                System.out.println("switch detected double, value < 1.0: " + d);
            }
            case double d when d >= 1.0 -> System.out.println("switch detected type double, having value >= 1.0: " + d);
            case String s -> System.out.println("switch detected type String: " + s);
            case Book b -> System.out.println("switch detected type Book: " + b);
            default -> System.out.println("Unknown type: " + value);
        }
    }
}


package org.cws.java24.review;

public class ScopedValueDemo {
    private static final ScopedValue<String> SCOPE = ScopedValue.newInstance(); // new instance of ScopedValue

    public static void main(String[] args) {
        System.out.println("Hello from main method");
        var demo = new ScopedValueDemo();
        demo.method1();
    }

    void method1() {
        System.out.println("Hello from method 1");
        ScopedValue.where(SCOPE, "hello").run(this::method2); // call method2, communicate scoped value "Hello" to method2
    }

    void method2() {
        System.out.println("Method 2: Getting a value from SCOPE before rebinding: " + SCOPE.get()); // hello
        ScopedValue.where(SCOPE, "CodingWalaShree").run(this::method3); // call method3, communicate "CodingWalaShree" to method3
        System.out.println("Method 2: Getting a value from SCOPE after rebinding: " + SCOPE.get()); // hello
    }

    void method3() {
        System.out.println("Method 3: Getting a value from SCOPE: " + SCOPE.get()); // CodingWalaShree
    }
}

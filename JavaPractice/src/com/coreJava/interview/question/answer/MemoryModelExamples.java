package com.coreJava.interview.question.answer;

/**
 * ============================================================
 * Java Memory Model: Stack vs Heap, Garbage Collection Basics
 * ============================================================
 *
 * Author: Professional Demonstration
 * Purpose: To explain how Java manages memory using stack and heap,
 *          and how garbage collection works, with professional comments
 *          and runnable examples.
 *
 * ------------------------------------------------------------
 * DEFINITIONS:
 * ------------------------------------------------------------
 * 1. Stack Memory:
 *    - Stores method calls, local variables, and references.
 *    - Follows LIFO (Last In, First Out).
 *    - Memory is automatically reclaimed when method exits.
 *    - Fast access, but limited in size.
 *
 * 2. Heap Memory:
 *    - Stores objects and instance variables.
 *    - Shared across all threads.
 *    - Larger but slower compared to stack.
 *    - Managed by Garbage Collector (GC).
 *
 * 3. Garbage Collection (GC):
 *    - Automatic memory management in Java.
 *    - Frees memory occupied by objects no longer referenced.
 *    - Prevents memory leaks and improves efficiency.
 *    - Uses algorithms like Mark-and-Sweep, Generational GC.
 *
 * ------------------------------------------------------------
 * COMPARISON TABLE:
 * ------------------------------------------------------------
 * | Feature          | Stack Memory                        | Heap Memory                         |
 * |------------------|-------------------------------------|-------------------------------------|
 * | Stores           | Local variables, method calls       | Objects, instance variables         |
 * | Access Speed     | Faster                              | Slower                              |
 * | Size             | Limited                             | Larger                              |
 * | Thread Scope     | Each thread has its own stack       | Shared across all threads           |
 * | Managed By       | JVM automatically (method exit)     | Garbage Collector                   |
 *
 * ============================================================
 */

public class MemoryModelExamples {

    public static void main(String[] args) {
        // ------------------------------------------------------------
        // 1. STACK DEMO
        // ------------------------------------------------------------
        // Definition: Stack stores method calls and local variables.
        // Example: Each recursive call creates a new stack frame.
        System.out.println("Stack Demo: Factorial Calculation");
        int number = 5;
        int result = factorial(number); // recursive calls use stack
        System.out.println("Factorial of " + number + " = " + result);

        // ------------------------------------------------------------
        // 2. HEAP DEMO
        // ------------------------------------------------------------
        // Definition: Heap stores objects and instance variables.
        // Example: Creating objects allocates memory in heap.
        System.out.println("\nHeap Demo: Object Allocation");
        Person p1 = new Person("Alice");
        Person p2 = new Person("Bob");
        System.out.println("Person 1: " + p1.getName());
        System.out.println("Person 2: " + p2.getName());

        // ------------------------------------------------------------
        // 3. GARBAGE COLLECTION DEMO
        // ------------------------------------------------------------
        // Definition: GC frees memory of unreferenced objects.
        // Example: Nullifying references makes objects eligible for GC.
        System.out.println("\nGarbage Collection Demo:");
        p1 = null; // Alice object is now eligible for GC
        System.gc(); // Suggest JVM to run GC (not guaranteed)
        System.out.println("Requested Garbage Collection.");
    }

    // ------------------------------------------------------------
    // Recursive method to demonstrate stack usage
    // ------------------------------------------------------------
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1); // each call adds a new stack frame
    }

    // ------------------------------------------------------------
    // Class to demonstrate heap allocation
    // ------------------------------------------------------------
    static class Person {
        private String name;

        public Person(String name) {
            this.name = name; // stored in heap
        }

        public String getName() {
            return name;
        }

        // finalize() method (deprecated in modern Java) can show GC effect
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Garbage Collector reclaimed memory for Person: " + name);
        }
    }
}

package com.coreJava.interview.question.answer;

/**
 * ============================================================
 * Java Strings: Immutability, StringBuffer vs StringBuilder
 * ============================================================
 *
 * Author: Professional Demonstration
 * Purpose: To explain the differences between String, StringBuffer,
 *          and StringBuilder with professional comments and examples.
 *
 * ------------------------------------------------------------
 * DEFINITIONS:
 * ------------------------------------------------------------
 * 1. String (Immutable):
 *    - Once created, cannot be changed.
 *    - Any modification creates a new object in memory.
 *    - Thread-safe by design.
 *    - Best used for constants, keys, and values that should not change.
 *
 * 2. StringBuffer (Mutable, Synchronized):
 *    - Can be modified without creating new objects.
 *    - Synchronized → Thread-safe (safe for multi-threaded environments).
 *    - Slightly slower due to synchronization overhead.
 *    - Best used when multiple threads modify the same string.
 *
 * 3. StringBuilder (Mutable, Non-Synchronized):
 *    - Same as StringBuffer but not synchronized.
 *    - Faster performance in single-threaded applications.
 *    - Introduced in Java 1.5 for efficiency.
 *    - Best used for heavy string manipulation in single-threaded contexts.
 *
 * ------------------------------------------------------------
 * COMPARISON TABLE:
 * ------------------------------------------------------------
 * | Feature        | String        | StringBuffer       | StringBuilder       |
 * |----------------|---------------|--------------------|---------------------|
 * | Mutability     | Immutable     | Mutable            | Mutable             |
 * | Thread Safety  | Safe          | Safe (synchronized)| Not safe            |
 * | Performance    | Slower        | Slower (sync cost) | Faster              |
 * | Use Case       | Constants     | Multi-threaded     | Single-threaded     |
 *
 * ============================================================
 */

public class StringExamples {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1. STRING IMMUTABILITY DEMO
        // ------------------------------------------------------------
        // Definition: String is immutable. Any modification creates a new object.
        // Example: Concatenation without assignment does not change the original.
        String str = "Hello";
        str.concat(" World"); // Creates new object but not assigned
        System.out.println("String after concat without assignment: " + str); // Output: Hello

        str = str.concat(" World"); // Assign new object
        System.out.println("String after concat with assignment: " + str); // Output: Hello World


        // ------------------------------------------------------------
        // 2. STRINGBUFFER DEMO
        // ------------------------------------------------------------
        // Definition: StringBuffer is mutable and synchronized (thread-safe).
        // Example: Append, insert, reverse operations modify the same object.
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World"); // modifies same object
        System.out.println("StringBuffer after append: " + sb); // Output: Hello World

        sb.insert(5, " Java");
        System.out.println("StringBuffer after insert: " + sb); // Output: Hello Java World

        sb.reverse();
        System.out.println("StringBuffer after reverse: " + sb); // Output: dlroW avaJ olleH


        // ------------------------------------------------------------
        // 3. STRINGBUILDER DEMO
        // ------------------------------------------------------------
        // Definition: StringBuilder is mutable but not synchronized (not thread-safe).
        // Example: Append, delete, replace operations modify the same object.
        StringBuilder sbd = new StringBuilder("Hello");
        sbd.append(" World");
        System.out.println("StringBuilder after append: " + sbd); // Output: Hello World

        sbd.delete(5, 11);
        System.out.println("StringBuilder after delete: " + sbd); // Output: Hello

        sbd.replace(0, 5, "Hi");
        System.out.println("StringBuilder after replace: " + sbd); // Output: Hi


        // ------------------------------------------------------------
        // 4. PERFORMANCE BENCHMARK DEMO (Optional Advanced)
        // ------------------------------------------------------------
        // Definition: StringBuilder is faster than StringBuffer due to lack of synchronization.
        // Example: Compare execution time for multiple concatenations.
        long startTime, endTime;

        // Using String
        startTime = System.nanoTime();
        String testStr = "A";
        for (int i = 0; i < 10000; i++) {
            testStr += "B"; // creates new object each time
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by String: " + (endTime - startTime) + " ns");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer testSb = new StringBuffer("A");
        for (int i = 0; i < 10000; i++) {
            testSb.append("B"); // modifies same object
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + " ns");

        // Using StringBuilder
        startTime = System.nanoTime();
        StringBuilder testSbd = new StringBuilder("A");
        for (int i = 0; i < 10000; i++) {
            testSbd.append("B"); // modifies same object
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + " ns");
    }
}


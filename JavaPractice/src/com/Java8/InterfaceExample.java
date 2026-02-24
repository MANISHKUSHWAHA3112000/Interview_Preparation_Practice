package com.Java8;

/***
 * Functional Interface : An interface that contains only one abstract method is known as a functional interface; however,
 *  there is no restriction on the number of default and static methods that can be included within a functional interface.
 */
public class InterfaceExample {

	
    interface Practice {
        int findEvenOddSum(int n);
    }

    public static void main(String[] args) {
        Practice p = (i) -> {
            int evenSum = 0;
            int oddSum = 0;

            int lastDigit = i % 10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            } else {
                oddSum += lastDigit;
            }

            return (evenSum - oddSum);
        };

        System.out.println(p.findEvenOddSum(1234)); // Example input
    }
}

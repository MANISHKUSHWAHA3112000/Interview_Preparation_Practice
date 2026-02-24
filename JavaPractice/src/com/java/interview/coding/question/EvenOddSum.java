package com.java.interview.coding.question;

import java.util.Scanner;

public class EvenOddSum {

    public static int findEvenOddSum(int n) {
        int evenSum = 0, oddSum = 0;

        while (n > 0) {
            int lastDigit = n % 10;

            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            } else {
                oddSum += lastDigit;
            }
            n /= 10;
        }
        return evenSum - oddSum;
    }

    public static int findEvenOddSumUsingJava8(int n) {

        int evenSum = String.valueOf(n)
                            .chars()
                            .map(c -> c - '0')
                            .filter(d -> d % 2 == 0)
                            .sum();

        int oddSum = String.valueOf(n)
                           .chars()
                           .map(c -> c - '0')
                           .filter(d -> d % 2 != 0)
                           .sum();

        return evenSum - oddSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = findEvenOddSum(n);
        int ans2 = findEvenOddSumUsingJava8(n);

        System.out.println(ans);
        System.out.println(ans2);
    }
}

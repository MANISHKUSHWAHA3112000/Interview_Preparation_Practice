package com.java.interview.coding.question;

import java.util.Scanner;
import java.util.HashMap;

public class PalindromeSolutions {

    // 1. String Palindrome Check (two-pointer)
    // 👉 Use when interviewer asks: "Is this string a palindrome?"
    // Time: O(n), Space: O(1)
    public static boolean isPalindromeOrNot(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2. Sentence Palindrome Check (ignore spaces/punctuation)
    // 👉 Use when interviewer asks: "Check palindrome ignoring spaces/punctuation."
    // Time: O(n), Space: O(n)
    public static boolean isSentencePalindrome(String s) {
        String checkString = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String result = new StringBuilder(checkString).reverse().toString();
        return checkString.equals(result);
    }

    // 3. Number Palindrome Check (digit reversal)
    // 👉 Use when interviewer asks: "Is this number a palindrome?"
    // Time: O(log n), Space: O(1)
    public static boolean isNumberPalindrome(int n) {
        int original = n;
        int reversed = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reversed = reversed * 10 + lastDigit;
            n /= 10;
        }
        return original == reversed;
    }

    // 4. Anagram Palindrome Check (HashMap version)
    // 👉 Use when interviewer asks: "Can this string be rearranged into a palindrome?"
    // Time: O(n), Space: O(distinct characters) → O(1) if alphabet is fixed
    public static int canFormPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        int oddCount = 0;
        for (int count : freq.values()) {
            if (count % 2 != 0) oddCount++;
        }
        if (s.length() % 2 == 0) return (oddCount == 0) ? 1 : 0;
        else return (oddCount == 1) ? 1 : 0;
    }

    // 5. Anagram Palindrome Check (Array version, optimized for lowercase letters)
    // 👉 Use when interviewer emphasizes optimization.
    // Time: O(n), Space: O(26) → constant
    public static int canFormPalindromeArray(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) oddCount++;
        }
        if (s.length() % 2 == 0) return (oddCount == 0) ? 1 : 0;
        else return (oddCount == 1) ? 1 : 0;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Test string palindrome
        String s = sc.nextLine();
        System.out.println("Is Palindrome: " + isPalindromeOrNot(s));
        System.out.println("Sentence Palindrome: " + isSentencePalindrome(s));
        System.out.println("Can Form Palindrome (HashMap): " + canFormPalindrome(s));
        System.out.println("Can Form Palindrome (Array): " + canFormPalindromeArray(s));

        // Test number palindrome
        int n = sc.nextInt();
        System.out.println("Is Number Palindrome: " + isNumberPalindrome(n));

        sc.close();
    }
}

package com.dsa.Arrays;

/**
 * Comprehensive Array Algorithms Reference
 * ----------------------------------------
 * This file demonstrates common array problem-solving patterns in Java:
 * 1. Traversal / Iteration
 * 2. Two-Pointer Technique
 * 3. Sliding Window
 * 4. Hashing / Frequency Counting
 * 5. Prefix Sum
 * 6. Kadane’s Algorithm
 * 7. Divide and Conquer (Merge Sort)
 *
 * Each section includes:
 * - Algorithm description
 * - Java implementation
 * - Debugging tips
 *
 * Author: Manish (Learning DSA in Java)
 * Date: February 2026
 */

import java.util.Arrays;
import java.util.HashMap;

public class ArrayPatterns {

    // 1. Traversal / Iteration
    // Algorithm: Loop through array, update result at each step.
    public static void traversalExample() {
        int[] arr = {5, 3, 8, 2};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // accumulate sum
        }

        System.out.println("Traversal Example -> Sum = " + sum);
        // Debugging Tip: Print arr[i] inside loop to confirm traversal.
    }

    // 2. Two-Pointer Technique
    // Algorithm: Use two indices moving inward to check conditions.
    public static void twoPointerExample() {
        int[] arr = {1, 4, 2, 7, 5};
        int target = 9;
        Arrays.sort(arr); // required for two-pointer

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("Two-Pointer Example -> Pair: " + arr[left] + ", " + arr[right]);
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        // Debugging Tip: Print left, right, sum at each step.
    }

    // 3. Sliding Window
    // Algorithm: Maintain a window sum, slide across array.
    public static void slidingWindowExample() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println("Sliding Window Example -> Max sum = " + maxSum);
        // Debugging Tip: Print windowSum after each slide.
    }

    // 4. Hashing / Frequency Counting
    // Algorithm: Use HashMap to store frequency of elements.
    public static void frequencyCountExample() {
        int[] arr = {1, 2, 2, 3, 1, 4};
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println("Frequency Count Example -> " + freq);
        // Debugging Tip: Print map after each insertion.
    }

    // 5. Prefix Sum
    // Algorithm: Build prefix array, use it for range queries.
    public static void prefixSumExample() {
        int[] arr = {2, 4, 5, 7};
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // Range sum query [1,3]
        int l = 1, r = 3;
        int sum = prefix[r] - (l > 0 ? prefix[l - 1] : 0);
        System.out.println("Prefix Sum Example -> Sum from index " + l + " to " + r + " = " + sum);
        // Debugging Tip: Print prefix array to confirm cumulative sums.
    }

    // 6. Kadane’s Algorithm
    // Algorithm: Track currentSum and maxSum for max subarray.
    public static void kadaneExample() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Kadane’s Algorithm Example -> Max subarray sum = " + maxSum);
        // Debugging Tip: Print currentSum and maxSum at each iteration.
    }

    // 7. Divide and Conquer (Merge Sort)
    // Algorithm: Recursively split array, then merge sorted halves.
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) left[i] = arr[l + i];
        for (int j = 0; j < n2; j++) right[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }

    public static void mergeSortExample() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        mergeSort(arr, 0, arr.length - 1);
        System.out.print("Merge Sort Example -> Sorted Array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
        // Debugging Tip: Print subarrays before merging to check recursion.
    }

    // Main method to run all examples
    public static void main(String[] args) {
        traversalExample();
        twoPointerExample();
        slidingWindowExample();
        frequencyCountExample();
        prefixSumExample();
        kadaneExample();
        mergeSortExample();
    }
}

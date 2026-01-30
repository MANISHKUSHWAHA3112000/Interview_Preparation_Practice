package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TwoPairsSums {

	public static ArrayList<ArrayList<Integer>> findTwoPairsSum(int arr[], int n) {
		Arrays.sort(arr);
		Set<List<Integer>> uniquePairs = new HashSet<>();
		HashSet<Integer> seen = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int x = arr[i];
			if (seen.contains(-x)) {
				List<Integer> pair = Arrays.asList(Math.min(x, -x), Math.max(x, -x));
				uniquePairs.add(pair);
			}
			seen.add(x);
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (List<Integer> pair : uniquePairs) {
			result.add(new ArrayList<>(pair));
		}

		// Sort final result
		result.sort((a, b) -> {
			if (!a.get(0).equals(b.get(0))) {
				return a.get(0) - b.get(0);
			} else {
				return a.get(1) - b.get(1);
			}
		});

		return result;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<ArrayList<Integer>> ans = findTwoPairsSum(arr, n);

		System.out.println("Two pairs sum are : " + ans);
	}
}

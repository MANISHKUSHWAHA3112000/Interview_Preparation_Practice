package com.java.interview.coding.question;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

	public static String findLongestCommonPrefix(String arr[]) {
		if (arr == null || arr.length == 0) {
			return "";
		}
		String prefix = arr[0];
		for (int i = 1; i < arr.length; i++) {
			while (arr[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}

	public static void main(String[] args) {

		String arr[] = { "geeksForgeeks", "geeks", "geek", "geezer" };

		String ans = findLongestCommonPrefix(arr);

		System.out.println("Longest Common Prefix : " + ans);

	}

}

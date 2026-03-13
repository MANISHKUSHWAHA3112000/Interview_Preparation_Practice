package com.java.interview.coding.question;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeating {
	public static Character firstUniqueChar(String str) {
	    return str.chars()
	        .mapToObj(c -> (char)c)
	        .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
	        .entrySet().stream()
	        .filter(e -> e.getValue() == 1)
	        .map(Map.Entry::getKey)
	        .findFirst()
	        .orElse(null);
	}

	public static void main(String[] args) {
	    System.out.println(firstUniqueChar("swiss")); // Output: w
	}


}

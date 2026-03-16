package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.*;

public class PascalTriangle {
	
	// using iterative method based on the binomial coefficient formula
	public static int pascalTriangle(int row,int col) {
		
		int x = row - 1;
		int y = col - 1;
		
		int result =1;
		
		for(int i=0;i<y;i++) {
			result *= (x-i);
			result /= (i+1);
		}
		return result;
	}
	
	// using iterative with looping condition
	public static List<List<Integer>> generate(int numRows) {
	      List<List<Integer>> result = new ArrayList<>();

	        for (int i = 0; i < numRows; i++) {
	            List<Integer> row = new ArrayList<>();
	            for (int j = 0; j <= i; j++) {
	                if (j == 0 || j == i) {
	                    row.add(1); 
	                } else {
	                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
	                }
	            }
	            result.add(row);
	        }
	        return result;
	    }
	
	// using java 8 features
	 public static List<List<Integer>> generate2(int numRows) {
	        List<List<Integer>> result = new ArrayList<>();

	        IntStream.range(0, numRows).forEach(i -> {
	            List<Integer> row = IntStream.range(0, i + 1)
	                    .mapToObj(j -> (j == 0 || j == i)
	                            ? 1
	                            : result.get(i - 1).get(j - 1) + result.get(i - 1).get(j))
	                    .collect(Collectors.toList());
	            result.add(row);
	        });

	        return result;
	 }
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		// First approach using int return type
		/**
		int ans = pascalTriangle(row,col);
		
		for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalTriangle(i, j) + " ");
            }
            System.out.println();
        }
        **/
		
		// Second approach using List<List<Integer>> return type
//		List<List<Integer>> ans2 =generate(row); 
		
		// Third approach using Java 8
		List<List<Integer>> ans3 = generate2(row);
		
		for (List<Integer> rows : ans3) {
            System.out.println(rows);
        }
        sc.close();
	}

}

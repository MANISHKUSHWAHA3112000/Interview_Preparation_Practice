package com.java.interview.coding.question;

import java.util.Scanner;

public class IndexOfFirstStringOccurence {
	
	public static int findIndexOfFirstStringOccurence(String s,String key) {
//		ManishManish
		for(int i=0;i<s.length();i++) {
			if(s.substring(i)==key) {
				return i;
			}
		}
		return -1;
		
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		// ManishManish
		
		String key = sc.nextLine();
		//Man 
		
		int ans = findIndexOfFirstStringOccurence(s,key);
		
		System.out.println("First occurence of string are : " + ans);
	}

}

package com.coreJava.codingQuestion;

import java.util.Scanner;

public class BasicCodingQuestion {
	
	// Question:1 Write a program to return the number from 1 to 100 without using the inbuild function and numbers ?
//	public static void printNumber() {
//		
//		// If we want to return the number from 0 to 100
//		for(int i='A'-'A';i<='d';i++) {
//			System.out.print(i+ " ");
//		}
//		System.out.println();
//		
//		// If we want to return the number from 1 to 100
//			for(int i='A'/'A';i<='d';i++) {
//				System.out.print(i+" ");
//			}
//		}
	
	// Question:2 Write a program that Given two strings S1 and S2 as input. Your task is to concatenate two strings and then reverse the string. Finally print the reversed string.
	
	public static String concateString(String a,String b) {
		
		StringBuffer stringBuffer = new StringBuffer();
		return b;
	    
	}
	
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
//		printNumber();
		
		String s1= scanner.nextLine();
		String s2= scanner.nextLine();
		
		String resultString= concateString(s1,s2);
		
		System.out.println(resultString);
		
		scanner.close();
	}

}

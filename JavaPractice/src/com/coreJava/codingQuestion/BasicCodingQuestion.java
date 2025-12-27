package com.coreJava.codingQuestion;

import java.util.Scanner;

public class BasicCodingQuestion {
	
	// Question:1 Write a program to return the number from 1 to 100 without using the inbuild function and numbers ?
	public static void printNumber() {
		
		// If we want to return the number from 0 to 100
		for(int i='A'-'A';i<='d';i++) {
			System.out.print(i+ " ");
		}
		System.out.println();
		
		// If we want to return the number from 1 to 100
			for(int i='A'/'A';i<='d';i++) {
				System.out.print(i+" ");
			}
		}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		printNumber();
		
		scanner.close();
	}

}

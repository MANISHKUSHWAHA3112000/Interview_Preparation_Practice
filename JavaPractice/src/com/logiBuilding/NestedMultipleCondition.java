package com.logiBuilding;

import java.util.Scanner;

public class NestedMultipleCondition {
	/**
	public static boolean findThreeSide(int a, int b,int c) {
		if(a+b > c && b+c >a && c+a>b) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public static  boolean findEquiIsoSca(int a,int b,int c) {
		if(findThreeSide(a, b, c)) {
			if(a==b &&b==c)System.out.println("Equilateral");
			else if(a==b || b==c || c==a)System.out.println("Isosceles");
			else System.out.println("Scanalen");
		}
		return false;
	}
	**/
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

//        // Input three sides
//        System.out.print("Enter side a: ");
//        int a = sc.nextInt();
//        System.out.print("Enter side b: ");
//        int b = sc.nextInt();
//        System.out.print("Enter side c: ");
//        int c = sc.nextInt();

//        boolean ans = findThreeSide(a,b,c);
//        boolean ans2=findEquiIsoSca(a,b,c);
        
//        System.out.println(ans);
//        System.out.println(ans2);
	}

}

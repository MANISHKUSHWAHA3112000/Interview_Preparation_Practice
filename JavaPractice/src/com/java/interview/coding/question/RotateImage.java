package com.java.interview.coding.question;

import java.util.Scanner;

public class RotateImage {

	public static void rotateImage(int arr[][]) {
		int n = arr.length;
		
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				int temp = arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
				
			}
		}
		
		for(int i=0;i<n;i++) {
			int left=0;int right = n-1;
			while(left<right) {
				int temp = arr[i][left];
				arr[i][left]=arr[i][right];
				arr[i][right]=temp;
				left++;
				right--;
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		rotateImage(arr);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
}

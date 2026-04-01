package justPractice;

import java.util.Arrays;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		
		int arr[]={1, 6, 2, 5, 3, 4};
		int windowSize=2;
		int maxSum=0;
		int totalSum=0;
		for(int i=0;i<arr.length-windowSize;i++) {
			int sum =0;
			for(int j=i;j<i+windowSize;j++) {
				sum+=arr[j];
			}
			totalSum+=sum;
		}
		System.out.println(totalSum);
	}
}

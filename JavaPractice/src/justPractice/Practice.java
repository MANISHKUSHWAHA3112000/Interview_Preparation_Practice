package justPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		
		int arr[]={5, 3, 1, 6, 9};
		
		// second method
		Arrays.sort(arr);
		
		int minElement=arr[0];
		int left=0;int right=arr.length-1;
		
		while(left<right) {
			if(arr[left]<minElement) {
				left++;
			}
			else if (arr[left]==minElement) {
				System.out.println(arr[left]);
				left++;
				right--;
			}
			else {
				right--;
			}
		}
	}
}

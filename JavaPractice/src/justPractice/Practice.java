package justPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
//		int arr[] = {3,5,2,5,7,8}; 

		String s = "helww ldlds";
		char[] arr = s.toCharArray();

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] == ' ') {
				left++;
				continue;
			}
			if (arr[right] == ' ') {
				right--;
				continue;
			}

			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}

		System.out.println(new String(arr));
	}
}

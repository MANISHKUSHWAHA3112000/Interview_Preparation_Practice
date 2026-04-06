package justPractice;

import java.util.Arrays;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		
		int n = 555;
		int original=n;
		int reversed=0;
		
		while(n>0) {
			int lastDigit = n %10;
			reversed = reversed*10+lastDigit;
			n/=10;
		}
		if(original==reversed) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		
		string s = "dsfds";
		s=Character.isLetterOrDigit(n)
		
	}
}

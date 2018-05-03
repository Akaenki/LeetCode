	/** A faster (somehow) methond by reversig number */
public class pldrNumFast {
	public static boolean isPalindrome(int x){
		if(x < 0) return false; 
		if(x == 0 || x/10 == 0) return true; 
		if(x%10 == 0) return false;

		/** reverse number */
		int reverse = 0;
		int origin = x;
		while(x > 0){
			reverse = reverse*10 + x%10;
			x = x/10;
		}
		return origin == reverse;
	}

	public static void main(String[] args){
		System.out.println(isPalindrome(12421));
	}
}
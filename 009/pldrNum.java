import java.util.Deque;
import java.util.LinkedList;

/** An naive method using Deque */
public class pldrNum {
	public static boolean isPalindrome(int x){
		/* Negative numbers are always not panlindrome */
		if(x < 0) { return false; }
		if(x == 0) { return true; }

		/* Extract Numbers */
		Deque<Integer> list = parseNum(x);		
		return isPalindrome(list);
	}

	/** helper functions */
	private static boolean isPalindrome(Deque<Integer> intList){
		if(intList.size()<=1){
			return true;
		}
		if(intList.removeFirst() == intList.removeLast()){
			return isPalindrome(intList);
		}
		return false;
	}

	private static Deque<Integer> parseNum(int x){
		Deque<Integer> intList = new LinkedList<Integer>();
		while(x > 0){
			int lastDigit = x % 10;
			intList.addFirst(lastDigit);
			x = x/10;
		}
		return intList;
	}

	public static void main(String[] args){
		System.out.println(isPalindrome(0));
	}
	
}
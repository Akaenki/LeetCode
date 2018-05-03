import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/** A solution using Map 
 *  This code beats 99% java submission lol
 */
public class twoSum {
	public static int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<>();
		int[] ndx = new int[2];

		for(int i = 0; i<nums.length; i++){
			int value = nums[i];
			if(map.containsKey(target - value)){
				ndx[0] = map.get(target - value);
				ndx[1] = i;
				break; 
			}
			map.put(value,i);
		}
		return ndx;
	}

	@Test
	public void simpletest(){
		int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] results = twoSum(nums, 7);

		int[] expected = new int[] {2, 3};

		assertEquals(expected[0],results[0]);
		assertEquals(expected[1],results[1]);
	}
}

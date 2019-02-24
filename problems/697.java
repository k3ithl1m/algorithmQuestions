import java.util.*;
import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {
	if (nums.length == 1) return nums.length;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>(),  
            left = new HashMap<Integer, Integer>(), right = new HashMap<Integer, Integer>();

	for (int i = 0; i < nums.length; i++) {
	    int temp = nums[i];
	    if (left.get(temp) == null) left.put(temp, i);
	    right.put(temp, i);
	    count.put(temp, count.getOrDefault(temp, 0) + 1);
        }
	
	int result = nums.length;
 	int degree = Collections.max(count.values());
	for (int c : count.keySet()) {
	    if (count.get(c) == degree) {
		result = Math.min(result, right.get(c) - left.get(c) + 1);
	    }
	}
	return result;
    }
}


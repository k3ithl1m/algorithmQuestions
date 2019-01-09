/*
 * [556] Next Greater Element III
 *
 * https://leetcode.com/problems/next-greater-element-iii/description/
 *
 * algorithms
<<<<<<< HEAD
 * Medium (29.37%)
 * Total Accepted:    20.6K
 * Total Submissions: 70.3K
=======
 * Medium (28.93%)
 * Total Accepted:    20.7K
 * Total Submissions: 70.5K
>>>>>>> d8a49312a8e3fbd4ea6f3e3961721bdbfea7caba
 * Testcase Example:  '12'
 *
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: 12
 * Output: 21
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 21
 * Output: -1
 * 
 * 
 * 
 * 
 */
class Solution {
    public int nextGreaterElement(int n) {
<<<<<<< HEAD
        
=======
	char[] car = String.valueOf(n).toCharArray();
	int tracker = -1;
	for (int i = car.length-1; i >= 1; i--) {
		if (car[i-1] < car[i]) {
			tracker = i-1;	
			break;
		}
	}        

	if (tracker >= 0) {
		int temp = tracker + 1;
		for (int i = tracker + 1; i < car.length; i++) {
			if (car[temp] > car[i] && car[i] > car[tracker]) {
				temp = i;
			}	
		}
		char newtemp = car[tracker];
		car[tracker] = car[temp];
		car[temp] = newtemp;
		Arrays.sort(car, tracker + 1, car.length);
	} else {
		return tracker;
	}

	try {
		int result = Integer.parseInt(new String(car));
		return result;
	} catch(Exception e) {
		return -1;
	}
>>>>>>> d8a49312a8e3fbd4ea6f3e3961721bdbfea7caba
    }
}

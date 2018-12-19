/*
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (29.53%)
 * Total Accepted:    193.5K
 * Total Submissions: 655.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
	if (nums.length < 2) return;
	int pos = -1;
	int newPos = - 1;
	for (int i = nums.length - 1; i >= 1; i--) {
		if (nums[i] > nums[i-1]) {
			pos = i-1;
			newPos = i;
			break;	
		}	
	}        
	
	if (pos > -1) {
		for (int i = pos; i < nums.length; i++) {
				System.out.println(nums[newPos] + " " + nums[i]);

			if (nums[pos] < nums[i] && nums[newPos] > nums[i]) {
				newPos = i;	
			}
		}
	}

	if (newPos > -1) {
		int temp = nums[newPos];
		nums[newPos] = nums[pos];
		nums[pos] = temp;
	}

	if (pos == -1) Arrays.sort(nums);
	else {
		Arrays.sort(nums, pos + 1, nums.length);
	}
    }
}

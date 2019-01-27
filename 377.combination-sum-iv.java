/*
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (43.37%)
 * Total Accepted:    71.7K
 * Total Submissions: 165.4K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * ⁠Given an integer array with all positive numbers and no duplicates, find
 * the number of possible combinations that add up to a positive integer
 * target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * 
 * 
 * 
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers? 
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
	if (nums.length == 0) return 0;
	int[] storingSeenTarget = new int[target+1];
	Arrays.fill(storingSeenTarget, -1);
	storingSeenTarget[0] = 1;
       	return recurseCount(nums, target, 0, storingSeenTarget);
    }

    public int recurseCount(int[] nums, int target, int currentTotal, int[] storingSeenTarget) {
	if (storingSeenTarget[target] != -1) return storingSeenTarget[target];
	int res = 0;
	for (int i = 0; i < nums.length; i++) {
		if (target>=nums[i]) {
			res += recurseCount(nums, target-nums[i], currentTotal + nums[i], storingSeenTarget);	
		}
	} 
	storingSeenTarget[target] = res;
	return res;

    }
}

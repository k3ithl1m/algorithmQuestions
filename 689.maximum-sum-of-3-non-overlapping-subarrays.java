 /*
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 *
 * algorithms
 * Hard (42.79%)
 * Total Accepted:    20.5K
 * Total Submissions: 47.8K
 * Testcase Example:  '[1,2,1,2,6,7,5,1]\n2'
 *
 * 
 * In a given array nums of positive integers, find three non-overlapping
 * subarrays with maximum sum.
 * 
 * 
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k
 * entries.
 * 
 * 
 * Return the result as a list of indices representing the starting position of
 * each interval (0-indexed).  If there are multiple answers, return the
 * lexicographically smallest one.
 * 
 * Example:
 * 
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting
 * indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be
 * lexicographically larger.
 * 
 * 
 * 
 * Note:
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 * 
 */
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
	int[] total = new int[nums.length];
	int[][] maxStore = new int[3][nums.length];
	int[][] maxStoreLocation = new int[3][nums.length];
	for (int i = 0; i < nums.length; i++) {
		int subarrayTotal = 0;
		for (int j = 0; j < k; j++) {
			if (i+j >= nums.length) continue;
			subarrayTotal += nums[i+j];
		}
		total[i] = subarrayTotal;
	}        
	int[] result = new int[3];
	for (int i = total.length - 1; i >= 2*k; i--)  {
		if (i == total.length-1) {
			maxStore[2][total.length-1] = total[total.length-1];
			maxStoreLocation[2][total.length-1] = i;
			continue;
		}
		maxStore[2][i] = Math.max(total[i], maxStore[2][i+1]);
		if (total[i] > maxStore[2][i+1]) {
			maxStoreLocation[2][i] = i;
		} else maxStoreLocation[2][i] = maxStoreLocation[2][i+1];
	}
	for ( int j = total.length - k - 1; j >= k; j--) {
		if (j == total.length - k - 1) {
			maxStore[1][total.length-k-1] = total[total.length-k-1] + maxStore[2][total.length-1];
			maxStoreLocation[1][total.length-k-1] = j;
		System.out.println("at j " + maxStore[1][j]);
			continue;
		}
		int value = total[j] + maxStore[2][j+k];
		System.out.println(total[j] + " " + maxStore[2][j+k]);
		maxStore[1][j] = Math.max(value, maxStore[1][j+1]);
		if (value > maxStore[1][j+1]) {
			maxStoreLocation[1][j] = j;
		} else maxStoreLocation[1][j] = maxStoreLocation[1][j+1];
	}
	for (int l = nums.length -2*k - 1; l >= 0; l--) {
		if (l ==nums.length-2*k-1) {
			maxStore[0][nums.length-2*k-1] = total[nums.length-2*k-1] + maxStore[1][nums.length-k-1];
			maxStoreLocation[0][nums.length-2*k-1] = nums.length-2*k-1;
			continue;
		}
		int value = total[l] + maxStore[1][l+k];
		maxStore[0][l] = Math.max(value, maxStore[0][l+1]);
		if (value >= maxStore[0][l+1]) {
			maxStoreLocation[0][l] = l;
		} else maxStoreLocation[0][l] = maxStoreLocation[0][l+1];
		System.out.println("at l" + maxStore[0][l]);
	} 
	result[0] = maxStoreLocation[0][0];
	result[1] = maxStoreLocation[1][result[0] + k];
	result[2] = maxStoreLocation[2][result[1] + k];
	return result;
    }
}

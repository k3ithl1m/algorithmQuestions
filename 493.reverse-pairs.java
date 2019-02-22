/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 *
 * https://leetcode.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (22.33%)
 * Total Accepted:    20.6K
 * Total Submissions: 92.3K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and
 * nums[i] > 2*nums[j].
 * 
 * You need to return the number of important reverse pairs in the given
 * array.
 * 
 * Example1:
 * 
 * Input: [1,3,2,3,1]
 * Output: 2
 * 
 * 
 * Example2:
 * 
 * Input: [2,4,3,5,1]
 * Output: 3
 * 
 * 
 * Note:
 * 
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 * 
 * 
 */
class Solution {
    public int reversePairs(int[] pairs) {
	if (pairs.length <= 1) return 0;
	int[] count = new int[]{0};
	mergesort(pairs, new int[pairs.length], 0, pairs.length-1, count);
	return count[0]; 
    }

    private void mergesort(int[] pairs, int[] subarray, int start, int end, int[] count) {
	if (start >= end) return;
	int middle = start + (end-start)/2;
	mergesort(pairs, subarray, start, middle, count);
	mergesort(pairs, subarray, middle+1, end, count);
	mergearrays(pairs, subarray, start, end, count);
    }

    private void mergearrays(int[] pairs, int[] subarray, int start, int end, int[] count) {
	int middle = start + (end-start)/2;
	int index = start, leftstart = start, leftend = middle, rightstart = middle+1, rightend = end;
	int min = Integer.MAX_VALUE;
	for (int i = start, j=rightstart; i <= leftend; i++) {
		while(j<= rightend && pairs[i]/2.0 > pairs[j]) j++;
		count[0] += j-(rightstart);
	}
	while (leftstart <= leftend && rightstart <= rightend) {
		int leftval = pairs[leftstart];
		int rightval = pairs[rightstart];
		min = Math.min(min, rightval);
		if (leftval > rightval) {
			subarray[index++] = rightval;
			rightstart++;
		} else {
			subarray[index++] = leftval;
			leftstart++;
		}
	}

	while(leftstart<=leftend) {
		subarray[index++] = pairs[leftstart++];
	}

	while(rightstart<=rightend) {
		subarray[index++] = pairs[rightstart++];
	}
	System.arraycopy(subarray, start, pairs, start, end-start+1);
    }
}

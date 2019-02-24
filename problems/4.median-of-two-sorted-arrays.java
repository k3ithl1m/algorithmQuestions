/*
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (23.67%)
 * Total Accepted:    293.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	if (nums2.length < nums1.length) {
		int[] temp = nums1;
		nums1 = nums2;
		nums2 = temp;
	}
	
	int totalLength = nums1.length + nums2.length + 1;
	int iLeft = 0, iRight = nums1.length;
	int i = 0, j = 0, median = 0;
	int n = nums1.length, m = nums2.length;
	while (iLeft <= iRight) {
		i = iLeft + ((iRight - iLeft) / 2);
		j = (totalLength / 2) - i;
		if (i < n && j > 0 && nums1[i] < nums2[j-1]) iLeft = i + 1;
		else if (j < m && i > 0 && nums1[i-1] > nums2[j]) iRight = i - 1;
		else {
			if (i == 0) median = nums2[j - 1];
			else if (j == 0) median = nums1[i - 1];
			else median = maximum(nums1[i-1], nums2[j-1]);	
			break;
		}
	}
	System.out.println(median);
	if ((n+m)%2 == 1) return (double)median;
	if (i==n) return (median + nums2[j]) / 2.0;
	if (j==m) return (median + nums1[i]) / 2.0;
	return (median + minimum(nums1[i], nums2[j])) / 2.0;
    }

    public int minimum(int a, int b) {
	if (a < b) return a;
	return b;
    }

    public int maximum(int a, int b) {
	if (a > b) return a;
	return b;
    }
}

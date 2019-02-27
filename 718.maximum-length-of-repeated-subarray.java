/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 *
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * algorithms
 * Medium (44.25%)
 * Total Accepted:    26.3K
 * Total Submissions: 59.5K
 * Testcase Example:  '[1,2,3,2,1]\n[3,2,1,4,7]'
 *
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation: 
 * The repeated subarray with maximum length is [3, 2, 1].
 * 
 * 
 * 
 * Note:
 * 
 * 1 
 * 0 
 * 
 * 
 */
class Solution {

    public int findLength(int[] A, int[] B) {
	if (A == null || A.length == 0 || B == null || B.length == 0) return 0;
	int[] Bmemo = new int[B.length + 1];
	int maxLength = 0;
	for (int i = 1; i <= A.length; i++) {
		for (int j = B.length; j >=1; j--) {
			if (A[i-1] == B[j-1]) {
				Bmemo[j] = Bmemo[j-1] + 1;
				maxLength = Math.max(maxLength, Bmemo[j]);
			} else {
				Bmemo[j] = 0;
			}
		}
	}
	return maxLength;
    }














    public int findLength3(int[] A, int[] B) {
	if (A.length == 0 || B.length == 0) return 0;
	int maxLength = 0;
	int[] BMemo = new int[B.length + 1];
	for (int i = 1; i <= A.length; i++) {
		for (int j = B.length; j >= 1; j--) {
			if (A[i-1] == B[j-1]) {
				BMemo[j] = BMemo[j-1] + 1;
				maxLength = Math.max(maxLength, BMemo[j]);
			} else {
				BMemo[j] = 0;
			}
		}
	}
	return maxLength;
    }

    public int findLength2(int[] A, int[] B) {
	if (A.length == 0 || B.length == 0) return 0;        
	HashMap<Integer, ArrayList<Integer>> BValuePositionMap = new HashMap<Integer, ArrayList<Integer>>();
	for (int i = 0; i < B.length; i++) {
		ArrayList<Integer> valueList = BValuePositionMap.get(B[i]);
		if (valueList == null) {
			valueList = new ArrayList<Integer>();
			valueList.add(i);
			BValuePositionMap.put(B[i], valueList);
		} else {
			valueList.add(i);
		}
	}

	int maxLength = 0;
	for (int i = 0; i < A.length; i++) {
		int currentValue = A[i];
		ArrayList<Integer> currentValueList = BValuePositionMap.get(currentValue);
		if (currentValueList == null) continue;
		else {
			for (int j = 0; j < currentValueList.size(); j++) {
				int countLength = 0;
				int trackerAtA = i;
				int trackerAtB = currentValueList.get(j);
				while (trackerAtA < A.length && trackerAtB < B.length) {
					if (A[trackerAtA++] == B[trackerAtB++]) {
						countLength++;
						maxLength = Math.max(countLength, maxLength);
					} else break;
				}
			}
		}
	}

	return maxLength;
    }
}

/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (63.66%)
 * Total Accepted:    147.9K
 * Total Submissions: 232.2K
 * Testcase Example:  '2'
 *
 * Given a non negative integer number num. For every numbers i in the range 0
 * ≤ i ≤ num calculate the number of 1's in their binary representation and
 * return them as an array.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: [0,1,1]
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * 
 * 
 * Follow up:
 * 
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 * 
 */
class Solution {
    public int[] countBits(int num) {
	int[] resultList = new int[num + 1];
	resultList[0] = 0;
	if (num == 0) return resultList;
	resultList[1] = 1;
	if (num == 1) return resultList;
	int currentCount = 1;
	
	int pointer = 0;
	int countAtPos = 0;
	for (int i = 2; i <= num; i++) {
		resultList[i] = countAtPos = resultList[pointer] + 1;
		pointer++;
		if (currentCount < countAtPos) {
			currentCount = countAtPos;
			pointer = 0;
		}	
		
	}

	return resultList;
    }
}

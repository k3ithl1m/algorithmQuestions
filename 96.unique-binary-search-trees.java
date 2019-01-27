/*
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (42.96%)
 * Total Accepted:    165.1K
 * Total Submissions: 381.2K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
class Solution {
    public int numTrees(int n) {
	int[] totalSum = new int[n+1];
	totalSum[0] = 1;
	totalSum[1] = 1;
	int nextBinary = 3;
	int binaryMultiply = 2;
	for (int i = 2; i < totalSum.length; ++i) {
		int tempSum = 0;
		for (int j = 1; j <= i; ++j) {
			tempSum += totalSum[i-j] * totalSum[j-1];
		}
		totalSum[i] = tempSum;
	} 
	return totalSum[n]; 
    }
}

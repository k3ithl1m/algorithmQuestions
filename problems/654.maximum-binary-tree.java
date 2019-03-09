/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree *
 * https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (74.88%)
 * Total Accepted:    68.7K
 * Total Submissions: 91.8K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 
 * Given an integer array with no duplicates. A maximum tree building on this
 * array is defined as follow:
 * 
 * The root is the maximum number in the array. 
 * The left subtree is the maximum tree constructed from left part subarray
 * divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray
 * divided by the maximum number. 
 * 
 * 
 * 
 * 
 * Construct the maximum tree by the given array and output the root node of
 * this tree.
 * 
 * 
 * Example 1:
 * 
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * 
 * ⁠     6
 * ⁠   /   \
 * ⁠  3     5
 * ⁠   \    / 
 * ⁠    2  0   
 * ⁠      \
 * ⁠       1
 * 
 * 
 * 
 * Note:
 * 
 * The size of the given array will be in the range [1,1000].
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //the question is, do we have to always find the max number?
    //the easiest way is to recurse while looping the start to end.
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = constructTreeNode(nums, 0, nums.length);
	return root;
    }

    private TreeNode constructTreeNode(int[] nums, int start, int end) {
	if (start == end) return null;
	int maxPosition = start, maxValue = Integer.MIN_VALUE;
	for (int i = start; i < end; i++) {
		if (nums[i] > maxValue) {
			maxPosition = i;
			maxValue = nums[i];
		}
	}

	TreeNode root = new TreeNode(maxValue);
	root.left = constructTreeNode(nums, start, maxPosition);
	root.right = constructTreeNode(nums, maxPosition+1, end);
	return root;
    }
}

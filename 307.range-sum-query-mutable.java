/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * algorithms
 * Medium (26.96%)
 * Total Accepted:    63.7K
 * Total Submissions: 235.5K
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 * 
 * Example:
 * 
 * 
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * 
 * Note:
 * 
 * 
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 * 
 * 
 */
class NumArray {

	TreeNode root;
	int[] storeArray;

    public NumArray(int[] nums) {
	if (nums.length == 0) root = new TreeNode(0,0,0);
	else {
		root = populateTree(nums, 0, nums.length - 1);
	}        
	storeArray = new int[nums.length];
	for (int i = 0; i < nums.length; i++) {
		storeArray[i] = nums[i];
	}
    }

    public TreeNode populateTree(int[] nums, int start, int end) {
	if (start == end) return new TreeNode(start, end, nums[start]);
	else {
		int mid = start + (end - start) / 2;
		TreeNode next = new TreeNode(start, end);
		next.left = populateTree(nums, start, mid);
		next.right = populateTree(nums, mid + 1, end);
		next.val = next.left.val + next.right.val;
		return next;
	}
    }
    
    public void update(int i, int val) {
	updateTree(val, i, root);
    }

    private void updateTree(int updatingVal, int position, TreeNode currentNode) {
	if (currentNode.start == currentNode.end) currentNode.val = updatingVal;
	else {
		if (position <= currentNode.mid) updateTree(updatingVal, position, currentNode.left);
		else updateTree(updatingVal, position, currentNode.right);
		currentNode.val = currentNode.left.val + currentNode.right.val;
	}
    }
    
    public int sumRange(int i, int j) {
        int val = findTreeRange(i, j, root);
	return val;
    }
    
    public int findTreeRange(int i, int j, TreeNode currentNode) {
	if (i == currentNode.start && j == currentNode.end) return currentNode.val;
	else {
		if (j <= currentNode.mid) {
			return findTreeRange(i, j, currentNode.left);
		} else if ( i > currentNode.mid) return findTreeRange(i, j, currentNode.right);
		else return findTreeRange(i, currentNode.mid, currentNode.left) 
				+ findTreeRange(currentNode.mid+1, j, currentNode.right);
	}
    }

}

class TreeNode {
	int start;
	int end;
	int val;
	int mid;
	boolean endIsSame;
	TreeNode left;
	TreeNode right;

	public TreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.mid = start + (end - start) / 2;
		endIsSame = start == end;
	}

	public TreeNode(int start, int end, int val) {
		this.start = start;
		this.end = end;
		this.mid = start + (end - start) / 2;
		endIsSame = start == end;
		this.val = val;
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

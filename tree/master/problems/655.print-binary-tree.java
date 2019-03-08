/*
 * @lc app=leetcode id=655 lang=java
 *
 * [655] Print Binary Tree
 *
 * https://leetcode.com/problems/print-binary-tree/description/
 *
 * algorithms
 * Medium (50.73%)
 * Total Accepted:    17.3K
 * Total Submissions: 34K
 * Testcase Example:  '[1,2]'
 *
 * Print a binary tree in an m*n 2D string array following these rules: 
 * 
 * 
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle
 * of the first row it can be put. The column and the row where the root node
 * belongs will separate the rest space into two parts (left-bottom part and
 * right-bottom part). You should print the left subtree in the left-bottom
 * part and print the right subtree in the right-bottom part. The left-bottom
 * part and the right-bottom part should have the same size. Even if one
 * subtree is none while the other is not, you don't need to print anything for
 * the none subtree but still need to leave the space as large as that for the
 * other subtree. However, if two subtrees are none, then you don't need to
 * leave space for both of them. 
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ⁠    1
 * ⁠   /
 * ⁠  2
 * Output:
 * [["", "1", ""],
 * ⁠["2", "", ""]]
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * ⁠    1
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \
 * ⁠    4
 * Output:
 * [["", "", "", "1", "", "", ""],
 * ⁠["", "2", "", "", "", "3", ""],
 * ⁠["", "", "4", "", "", "", ""]]
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * ⁠     1
 * ⁠    / \
 * ⁠   2   5
 * ⁠  / 
 * ⁠ 3 
 * ⁠/ 
 * 4 
 * Output:
 * 
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ⁠["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ⁠["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ⁠["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 
 * 
 * 
 * Note:
 * The height of binary tree is in the range of [1, 10].
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
	//we can first count the level and with the level, we can 
	// as height increase, we take child multiply by 2 and add it to the sum
	// as we are going down, we start from the middle, 
	// 	if we go left, we get mid of mid - left
	//	if we go right, we get mid of mid + (right - mid)/2
    public List<List<String>> printTree(TreeNode root) {
	ArrayList<List<String>> resultList = new ArrayList<>();
     	if (root == null) return resultList;
	if (root.left == null && root.right == null) {
		ArrayList<String> firstLineList = new ArrayList<>();
		firstLineList.add(String.valueOf(root.val));
		resultList.add(firstLineList);
		return resultList;
	}

	int maxHeight = findMaxHeightOfTree(root, 0);
	int findSize = 1;
	for (int i = 1; i < maxHeight; i++) {
		findSize = findSize << 1;
		findSize = findSize + 1;
	}
	for (int i = 0; i < maxHeight; i++) {
		ArrayList<String> stringList = new ArrayList<>();
		for (int j = 0; j < findSize; j++) {
			stringList.add("");
		}
		resultList.add(stringList);
	}
	fillResultList(root, 0, 0, findSize, resultList);
	return resultList;
    }

    private void fillResultList(TreeNode root, int level, int start, int end, List<List<String>> resultList) {
	if (root == null) return;
	int mid = start + (end - start) / 2;
	resultList.get(level).set(mid, String.valueOf(root.val));
	fillResultList(root.left, level + 1, start, mid, resultList);
	fillResultList(root.right, level + 1, mid, end, resultList);
    }

    private int findMaxHeightOfTree(TreeNode root, int level) {
	if (root == null) return level;
	int maxHeight = Math.max(findMaxHeightOfTree(root.left, level+1),
				findMaxHeightOfTree(root.right, level+1));
	return maxHeight;
    }
}

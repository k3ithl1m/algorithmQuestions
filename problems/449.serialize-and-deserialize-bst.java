/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 *
 * algorithms
 * Medium (45.48%)
 * Total Accepted:    48.7K
 * Total Submissions: 106.7K
 * Testcase Example:  '[2,1,3]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree
 * structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
	if (root == null) return "";
	String resultString = root.val + "," + serialize(root.left)  + serialize(root.right);
	return resultString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
	if (data.length() == 0) return null;
	Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
	return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> q, int lower, int upper) {
	if (q.isEmpty()) return null;
	String value = q.peek();
	int val = Integer.parseInt(value);
	if (val < lower || val > upper) return null;
	q.poll();
	TreeNode root = new TreeNode(val);
	root.left = deserialize(q, lower, root.val);
	root.right = deserialize(q, root.val, upper);
	return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

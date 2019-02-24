/*
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (37.95%)
 * Total Accepted:    144.1K
 * Total Submissions: 378.3K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 * * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * 
 * 
 * You may serialize the following tree:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * 
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
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
	StringBuilder sb = new StringBuilder();        
	sb.append("[");
	if (root == null) {
		sb.append("]");
		return sb.toString();
	}
	StringBuilder nullStr = new StringBuilder();        
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(root);
	boolean hasNull = false;
	while (!q.isEmpty()) {
		TreeNode temp = q.poll();
		if (temp == null) {
			hasNull = true;
			nullStr.append("null,");
			continue;
		} else {
			if (hasNull) {
				sb.append(nullStr.toString());
				nullStr = new StringBuilder();
				hasNull = false;
			}
			sb.append(temp.val);
			q.add(temp.left);
			q.add(temp.right);
		}
		
		sb.append(",");
		
	}

	sb.deleteCharAt(sb.length() -1);
	sb.append("]");
	return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
	System.out.println(data);
	String[] firstThrough = data.split("\\[|\\]");
	if (firstThrough.length < 2) return null;
	String[] secondThrough = firstThrough[1].split(",");
	System.out.println(secondThrough.length);
	

	int i = 1;	
	TreeNode root = new TreeNode(Integer.parseInt(secondThrough[0]));
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(root);
	while (!q.isEmpty() && i < secondThrough.length) {
		TreeNode temp = q.poll();
		if (!secondThrough[i].equals("null")) {
			temp.left = new TreeNode(Integer.parseInt(secondThrough[i]));
			System.out.println("Hey");
			q.add(temp.left);
		} 	
		if (i+1 <secondThrough.length && !secondThrough[i+1].equals("null")) {
			temp.right = new TreeNode(Integer.parseInt(secondThrough[i+1]));
			System.out.println("I'm Here");	
			q.add(temp.right);
		}
		i=i+2;
	}
	return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Easy (58.41%)
 * Total Accepted:    24.7K
 * Total Submissions: 42.3K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * We should return its level order traversal:
 * 
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 * 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
	ArrayList<List<Integer>> resultList = new ArrayList<>();
	if (root == null) return resultList;
	Queue<Node> nodeQueue = new LinkedList<>();
	nodeQueue.add(root);
	int size = nodeQueue.size();
	while (!nodeQueue.isEmpty()) {
		ArrayList<Integer> currentList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Node currentNode = nodeQueue.poll();
			currentList.add(currentNode.val);
			for (int j = 0; j < currentNode.children.size(); j++) {
				nodeQueue.add(currentNode.children.get(j));
			}
		}
		resultList.add(currentList);
		size = nodeQueue.size();
	}        

	return resultList;
    }
}

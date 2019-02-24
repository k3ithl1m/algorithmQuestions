/*
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (25.55%)
 * Total Accepted:    199.4K
 * Total Submissions: 780.6K
 * Testcase Example:  '{}'
 *
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * 
 * 
 * Return a deep copy of the list.
 * 
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
    public RandomListNode copyRandomList(RandomListNode head) {
	if (head == null) return null;	

	if(hm.containsKey(head)) return hm.get(head);
	RandomListNode temp = new RandomListNode(head.label);
	hm.put(head, temp);

	temp.next = this.copyRandomList(head.next);
	temp.random = this.copyRandomList(head.random);
	return temp;
    }
}

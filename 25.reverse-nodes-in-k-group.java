/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (34.56%)
 * Total Accepted:    159.8K
 * Total Submissions: 461.3K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode reverseKGroup2(ListNode head, int k) {
	if (head == null) return null;
	ListNode keepHead = new ListNode(0);
	keepHead.next = head;
	ListNode keepBeforeNode = keepHead;

	while(keepBeforeNode.next != null) {
		ListNode start = keepBeforeNode.next, back = keepBeforeNode.next, next = keepBeforeNode.next;
		int count = k-1;
		ListNode checkNode = keepBeforeNode;
		for (int i = 0; i < k; i++) {
			checkNode = checkNode.next;
			if (checkNode == null) break;
		}
		if (checkNode == null) break;
		while (back.next != null && count > 0) {
			next = back.next;
			back.next = next.next;
			next.next = start;
			start = next;
			keepBeforeNode.next = start;
			count--;
		}
		for (int i = 0; i < k; i++) {
			keepBeforeNode = keepBeforeNode.next;
			if (keepBeforeNode.next == null) break;
		}
		if (keepBeforeNode.next == null) break;
	}
	return keepHead.next;
    }
}

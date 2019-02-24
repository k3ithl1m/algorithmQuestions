/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (33.95%)
 * Total Accepted:    177.7K
 * Total Submissions: 523.4K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
	if (head == null) return head;
	ListNode frontNode = head;
	for (int i = 0; i < m - 2; i++) {
		frontNode = frontNode.next;
	}
	ListNode beforeNode = head;
	if (m > 1) {
		beforeNode = frontNode;
		frontNode = frontNode.next;
	}
	ListNode nextNode = frontNode, backNode = frontNode;
	for (int i = 0; i < n-m; i++) {
		nextNode = backNode.next;
		backNode.next = nextNode.next;
		nextNode.next = frontNode;
		frontNode = nextNode;
	}
	if (m > 1) {
		beforeNode.next = frontNode;
		return head;
	}
	return frontNode;
    }
}

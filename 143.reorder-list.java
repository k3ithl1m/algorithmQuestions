/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (29.82%)
 * Total Accepted:    143.3K
 * Total Submissions: 480.5K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
	if (head == null || head.next == null) return;
	ListNode slow = head, fast = head, prev = null;
	while(fast != null && fast.next != null) {
		prev = slow;
		slow = slow.next;
		fast = fast.next.next;
	}        
	prev=slow;
	slow = slow.next;
	ListNode tail = reverseNodes(slow);
	prev.next = null;
	ListNode dummy = new ListNode(0), backtracker = tail;
	while (head != null && tail !=null) {
		backtracker = tail.next;
		tail.next = head.next;
		head.next = tail;
		head = head.next;
		head = head.next;
		tail = backtracker;
	}
	head = dummy.next;
    }

    private ListNode reverseNodes(ListNode head) {
	if (head == null || head.next == null) return head;
	ListNode prev = new ListNode(0), current = head, next = head.next, left = head;
	prev.next = head;
	
	while (next != null) {
		current.next = next.next;
		next.next = left;
		prev.next = next;
		left = next;
		next = current.next;
	}

	return prev.next;
    }
}

/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (51.33%)
 * Total Accepted:    478.6K
 * Total Submissions: 929.2K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
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
    public ListNode reverseList1(ListNode head) {
	if (head == null) return head;
	ListNode prev = null;
	ListNode current = head;
	while (current != null) {
		ListNode nextNode = current.next;
		current.next=prev;
		prev = current;
		current = nextNode;
	}        
	return prev;
    }

    public ListNode reverseList(ListNode head) {
	if (head == null) return null;
	ListNode next = head;
	ListNode back = head;
	ListNode front = head;
	while(back.next != null) {
		next = back.next;
		back.next = next.next;
		next.next = front;
		front = next;
	}
	return front;
    }
}

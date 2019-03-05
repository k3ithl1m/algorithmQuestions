/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (33.95%)
 * Total Accepted:    170.7K
 * Total Submissions: 502.5K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
	if (head == null || head.next == null) return head;
	
	ListNode slow = head, fast = head, prev = null;
	while(fast != null && fast.next != null) {
		prev = slow;
		slow = slow.next;
		fast = fast.next.next;
	}

	prev.next = null;

	ListNode l1 = sortList(head);
	ListNode l2 = sortList(slow);
	
	return mergesort(l1,l2);
    }

    private ListNode mergesort(ListNode left, ListNode right) {
	ListNode tempHead = new ListNode(0), tracker = tempHead;
	while (left != null && right != null) {
		if (left.val < right.val) {
			tracker.next = left;
			left = left.next;
		} else {
			tracker.next = right;
			right = right.next;
		}
		tracker = tracker.next;
	}

	while(left!=null) {
		tracker.next = left;
		left = left.next;
		tracker=tracker.next;
	}

	while(right!=null) {
		tracker.next =right;
		right = right.next;
		tracker= tracker.next;
	}
	return tempHead.next;
    }
}

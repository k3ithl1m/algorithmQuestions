/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.20%)
 * Total Accepted:    169K
 * Total Submissions: 524.9K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
	//we check if the head of the link is null
	// whenever we reach a new node, we check if next is null,
	// if next is not null and not equals to the current node value, continue
	// if next is not null and equals current Node. We loop through until we find
	// the value that is not duplicate, then link prev to that node.
	// repeat.
	// return dummy .next later.

    public ListNode deleteDuplicates(ListNode head) {
	if (head == null) return null;
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode prev = dummy, current = head;
	while (current != null) {
		while(current.next!=null && current.val == current.next.val) current = current.next;
		if (prev.next == current) prev = prev.next;
		else {
			prev.next = current.next;
		}
		current = current.next;
	}
	return dummy.next;
    }
}

/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (36.32%)
 * Total Accepted:    153.2K
 * Total Submissions: 421.9K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
	if (head == null) return head;
	ListNode dummy = new ListNode(0);
	ListNode before = new ListNode(0);
	dummy.next = before;
	ListNode afterdummy = new ListNode(0);
	ListNode after = new ListNode(0);
	afterdummy.next = after;
	while (head != null) {
		if (head.val < x) {
			before.next = head;
			before = before.next;
		} else {
			after.next = head;
			after = after.next;
		}
		head = head.next;
	}
	after.next = null;
	before.next = afterdummy.next.next;
	return dummy.next.next;
    }
}

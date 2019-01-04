/*
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (30.18%)
 * Total Accepted:    268K
 * Total Submissions: 887.9K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Checker());
	ListNode res = new ListNode(0);
	ListNode n = res;
	for (int i = 0; i < lists.length; i++) {
		ListNode head = lists[i];
		
//		if(head != null) pq.offer(head);
		while(head != null) {
			pq.offer(head);
			head = head.next;
		}
	}
	while(!pq.isEmpty()) {
		n.next = new ListNode(pq.poll().val);
		n = n.next;
//		if (n.next != null) pq.offer(n.next);
	}
	return res.next;
    }
}

class Checker implements Comparator<ListNode> {

	@Override
	public int compare(ListNode x, ListNode y) {
		if (x.val < y.val) return -1;
		else if (x.val > y.val) return 1;
		else return 0;
	}
}

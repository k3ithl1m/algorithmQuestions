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
        int i = 0;
	while(lists.size() > 1) {
	    if (i+1>l.size()) i=0;
	    ListNode n = sort(lists.get(i), lists.get(i+1));
	    lists.add(i,n);
	    lists.remove(i+1);
	    lists.remove(i+2);
	    i+=2;
	}
	return lists.get(0);
    }

    public ListNode sort(ListNode a, ListNode b) {
	ListNode head;
	if (a.val > b.val) {
	    head = b;
	    b=b.next;
	} else {
	    head = a;
	    a=a.next;
	}
	ListNode pt = head;
	while (b!=null ||a!=null) {
	    if (a==null) {
		pt.next=b;
		break;
	    }
	    if(b==null) {
		pt.next=a;
		break;
	    }
	    if(a.val > b.val) {
		pt.next = b;
		b=b.next;
		pt=pt.next;
	    } else {
		pt.next = a;
		a=a.next;
		pt=pt.next;
	    }
	}
	return head;
    }
}

/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (35.36%)
 * Total Accepted:    235.2K
 * Total Submissions: 664.6K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
	ListNode fastNode = head, slowNode = head;
	while (fastNode != null && fastNode.next != null) {
		slowNode = slowNode.next;
		fastNode = fastNode.next.next;
	}
	//Reverse nodes here.
	if (fastNode != null) slowNode = slowNode.next;
	ListNode reverseNode = reverse(slowNode);
	fastNode = head;
	while (reverseNode != null) {
		if (reverseNode.val != fastNode.val) return false;
		fastNode = fastNode.next;
		reverseNode = reverseNode.next;
	}
	return true;
    }

    private ListNode reverse(ListNode head) {
	ListNode prev = null;
	while (head != null) {
		ListNode next = head.next;
		head.next = prev;
		prev = head;
		head = next;
	}
	return prev;
    }
}

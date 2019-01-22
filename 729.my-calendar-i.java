/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 *
 * https://leetcode.com/problems/my-calendar-i/description/
 *
 * algorithms
 * Medium (45.63%)
 * Total Accepted:    25.3K
 * Total Submissions: 55.4K
 * Testcase Example:  '["MyCalendar","book","book","book"]\n[[],[10,20],[15,25],[20,30]]'
 *
 * 
 * Implement a MyCalendar class to store your events. A new event can be added
 * if adding the event will not cause a double booking.
 * 
 * Your class will have the method, book(int start, int end).  Formally, this
 * represents a booking on the half open interval [start, end), the range of
 * real numbers x such that start .
 * 
 * A double booking happens when two events have some non-empty intersection
 * (ie., there is some time that is common to both events.)
 * 
 * For each call to the method MyCalendar.book, return true if the event can be
 * added to the calendar successfully without causing a double booking.
 * Otherwise, return false and do not add the event to the calendar.
 * 
 * 
 * Your class will be called like this:
 * MyCalendar cal = new MyCalendar();
 * MyCalendar.book(start, end)
 * 
 * Example 1:
 * 
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * Explanation: 
 * The first event can be booked.  The second can't because time 15 is already
 * booked by another event.
 * The third event can be booked, as the first event takes every time less than
 * 20, but not including 20.
 * 
 * 
 * 
 * Note:
 * The number of calls to MyCalendar.book per test case will be at most 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the
 * range [0, 10^9].
 * 
 */
class MyCalendar {

    private static class TreeNode {
	TreeNode left;
	TreeNode right;
	int start;
	int end;
	public TreeNode(int start, int end) {
		this.start = start;
		this.end = end;
	} 
    }
    TreeMap<Integer, Integer> scheduleKeeper;
    private TreeNode root;
    public MyCalendar() {
       	scheduleKeeper = new TreeMap();
    }

    public boolean book(int start, int end) {
	if (root == null) {
		root = new TreeNode(start, end);
		return true;
	}
	return helper(start, end, null, root);
    }
    
    public boolean book2(int start, int end) {
	boolean booked = false;
	Integer prev = scheduleKeeper.floorKey(start),
		next = scheduleKeeper.ceilingKey(start);
	if ( (prev == null || scheduleKeeper.get(prev) <= start) &&
		(next == null || end <= next)) {
		scheduleKeeper.put(start, end);
		return true;
	}
	return booked;
    }

    private boolean helper(int start, int end, TreeNode parent, TreeNode root) {
	if (root == null) {
		if (end <= parent.start) {
			parent.left = new TreeNode(start, end);
		} else {
			parent.right = new TreeNode(start, end);
		}
		return true;
	}
	if (end <= root.start) {
		return helper(start, end, root, root.left);
	}
	if (start >= root.end) {
		return helper(start, end, root, root.right);
	}
	return false;
    }
}

class Date {
	int start;
	int end;
	public Date(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

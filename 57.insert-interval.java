/*
 * [57] Insert Interval
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (30.21%)
 * Total Accepted:    154.8K
 * Total Submissions: 511.3K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	if (intervals.size() == 0) {
		intervals.add(newInterval);
		return intervals;
	}        
	int startLeft = -1, startRight = -1, endLeft = -1, endRight = -1;
	int st = newInterval.start, en = newInterval.end;
	for (int i = 0; i < intervals.size(); i++) {
		Interval temp = intervals.get(i);
		if ( st>temp.start && st < temp.end) {
			startLeft = startRight = i;
		} else if (st > temp.end) startLeft = i;
		else if (st < temp.start && startRight == -1) startRight = i;
		
		if (en > temp.start && en < temp.end) endLeft = endRight = i;
		else if (en > temp.end) endLeft = i;
		else if (en < temp.start && endRight == -1) endRight = i;
	}

	int start = 0, end = 0;
	if (startLeft == -1 && startRight == -1) {
		start = st;
	} else if (startLeft == startRight) start = intervals.get(startLeft).start;
	else start = st;
	if (endLeft == endRight) start = intervals.get(endLeft).end;
	else end = en;

	if (startRight != -1) {
		for ( int i = startRight; i < endRight; i++) {
			intervals.remove(startRight);
		}
	} else startRight = 0;
	Interval nI = new Interval(start, end);
	intervals.add( startRight, nI);
	return intervals;
    }
}

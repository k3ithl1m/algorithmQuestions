/*
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (33.50%)
 * Total Accepted:    258.4K
 * Total Submissions: 771.4K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
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
    public List<Interval> merge(List<Interval> intervals) {
	int head = 0, runner = 1;
	Collections.sort(intervals, (o1, o2) -> o1.start - (o2.start));
	ArrayList<Interval> result = new ArrayList<Interval>();
	while (head < intervals.size() ) {
	    Interval start = intervals.get(head);
	    
	    while (runner < intervals.size()) {
	    	Interval check = intervals.get(runner);
		if (check.end <= start.end) {
		  runner++;
		} else if(check.start <= start.end) {
		    start.end = check.end;
		    runner++;
		} else break;
	    }
	    result.add(new Interval(start.start, start.end));
	    head = runner;
	    runner = head + 1;
	}

	return result;
    }
}

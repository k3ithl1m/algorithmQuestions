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
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
	List<Interval> result = new ArrayList<Interval>();
	if (intervals.size() == 0) {
		result.add(newInterval);
		return result;
	} 

	int posInIntervals = 0;
	Interval intervalToInsert = new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE);
	while (posInIntervals < intervals.size()) {
		Interval tempInterval = intervals.get(posInIntervals);
		if (newInterval.start <= tempInterval.start) {
			intervalToInsert.start = newInterval.start;
			break;
		} else if (newInterval.start <= tempInterval.end) {
			intervalToInsert.start = tempInterval.start;
			break;
		}
		result.add(tempInterval);
		System.out.println("I'm here");
		posInIntervals++;
	}

	while(posInIntervals< intervals.size()) {
		Interval tempInterval = intervals.get(posInIntervals);
		if (newInterval.end < tempInterval.start) {
			intervalToInsert.end = newInterval.end;
			break;
		} else if (newInterval.end == tempInterval.start) {
			intervalToInsert.end = tempInterval.end;
			posInIntervals++;
			break;
		} else if (newInterval.end < tempInterval.end) {
			intervalToInsert.end = tempInterval.end;
			posInIntervals++;
			break;
		}
		posInIntervals++;
	}
	if (intervalToInsert.end == Integer.MIN_VALUE) intervalToInsert.end = newInterval.end;
	if (intervalToInsert.start == Integer.MIN_VALUE) intervalToInsert.start = newInterval.start;
	result.add(intervalToInsert);
	for (int i = posInIntervals; i < intervals.size(); i++) {
		result.add(intervals.get(i));
	}
	return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	List<Interval> ret = new ArrayList<>();
	int i = 0;
	while(i < intervals.size() && intervals.get(i).end<newInterval.start) {
		ret.add(intervals.get(i++));
	}
	int minStart = newInterval.start, maxEnd = newInterval.end;
	while(i<intervals.size()) {
		if (newInterval.end >= intervals.get(i).end || intervals.get(i).start <= newInterval.end) {
			minStart = Math.min(minStart, intervals.get(i).start);
			maxEnd = Math.max(maxEnd, intervals.get(i).end);
			i++;
		} else {
			break;
		}
	}
	ret.add(new Interval(minStart, maxEnd));
	while(i < intervals.size()) {
		ret.add(intervals.get(i++));
	}	
	return ret;
    }
}

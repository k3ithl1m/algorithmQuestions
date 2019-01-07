/*
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (34.34%)
 * Total Accepted:    116.9K
 * Total Submissions: 340.4K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * 
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * 
 * 
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
	ArrayList<String> res = new ArrayList<String>();
	if (nums.length == 0) return res;
	if (nums.length == 1) {
		res.add(""+nums[0]);
		return res;
	}
	int start = nums[0];
	int prev = nums[0];
	for (int i = 1; i < nums.length; i++) {
		if (nums[i] == prev + 1) {
			prev = nums[i];
			if (i == nums.length - 1) {
				StringBuilder sb = new StringBuilder();
				sb.append(start);
				sb.append("->");
				sb.append(prev);
				res.add(sb.toString());				
			}
			continue;
		} else {
			if (prev == start) {
				res.add("" + prev);
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(start);
				sb.append("->");
				sb.append(prev);
				res.add(sb.toString());
			}
			start = nums[i];
			prev = nums[i];
			if (i == nums.length - 1) {
				res.add("" + prev);
			}
		}
	}        
	return res;
    }

}

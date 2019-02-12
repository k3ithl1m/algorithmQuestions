/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (58.57%)
 * Total Accepted:    69.1K
 * Total Submissions: 117.8K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * 
 * 
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
	Arrays.sort(people, new Comparator<int[]>() {
		public int compare(int[] a, int[] b) {
			return (a[0]!=b[0]) ? b[0] - a[0] : a[1]-b[1];
		}
	});        

	List<int[]> result = new LinkedList<int[]>();
	for (int i = 0; i < people.length; i++) {
		result.add(people[i][1], people[i]);
	}
	return result.toArray(new int[people.length][]);
    }
}

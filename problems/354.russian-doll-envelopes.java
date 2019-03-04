/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 *
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 *
 * algorithms
 * Hard (33.53%)
 * Total Accepted:    40.9K
 * Total Submissions: 122K
 * Testcase Example:  '[[5,4],[6,4],[6,7],[2,3]]'
 *
 * You have a number of envelopes with widths and heights given as a pair of
 * integers (w, h). One envelope can fit into another if and only if both the
 * width and height of one envelope is greater than the width and height of the
 * other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one
 * inside other)
 * 
 * Note:
 * Rotation is not allowed.
 * 
 * Example:
 * 
 * 
 * 
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3 
 * Explanation: The maximum number of envelopes you can Russian doll is 3
 * ([2,3] => [5,4] => [6,7]).
 * 
 * 
 * 
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
	if(envelopes == null || envelopes.length == 0 
           || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
           } 
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }

    public int maxEnvelopes2(int[][] envelopes) {
	if (envelopes.length == 0) return 0;
	Arrays.sort(envelopes, new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			if (a[0] == b[0]) return b[1] - a[1];
			else return a[0] - b[0];
		}
	});       

	int[] countMax = new int[envelopes.length+1];
	int maxCount = 0;
	for (int i = 0; i < envelopes.length; i++) {
		int[] currentEnvelope = envelopes[i];
		for (int j = i+1; j < envelopes.length; j++) {
			if (currentEnvelope[0] < envelopes[j][0] && currentEnvelope[1] < envelopes[j][1]) {
				countMax[j] = Math.max(countMax[j], countMax[i] + 1);
				maxCount = Math.max(maxCount, countMax[j]);
			}
		}
	}

	return maxCount+1;
    }
}

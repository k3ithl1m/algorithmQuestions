/*
 * [386] Lexicographical Numbers
 *
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * algorithms
 * Medium (43.59%)
 * Total Accepted:    34.1K
 * Total Submissions: 78.3K
 * Testcase Example:  '13'
 *
 * 
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * 
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * 
 * 
 * Please optimize your algorithm to use less time and space. The input size
 * may be as large as 5,000,000.
 * 
 */
class Solution {
    // technically, we can build it into a tree
    // each tree starts with the first value from the front, then
    // we can dfs and use preorder to get the value
    // solution: {
    // 	ArrayList<Integer> ls = new ArrayList<Integer>();
    // 	for ( int i = 1; i < 10; i++) {
    // 		dfs(i, ar, n);
    // 	}
    // 	return ar;
    // }
    //
    //	dfs (int val, List<Integer> ar, int n) {
    //		if (val <= n) ar.add(val);
    //		for ( int i = 0; i < 10; i++) {
    //			dfs(val * 10 + i, ar, n);
    //		}
    //	}
    public List<Integer> lexicalOrder(int n) {
	    ArrayList<Integer> ar = new ArrayList<Integer>();
	    if (n < 1) return ar;
	    for (int i = 1; i < 10; i++) dfs(i, ar,n);
	    return ar;
    }

    public void dfs(int val, List<Integer> ar, int n) {
	    if ( val <= n) ar.add(val);
	    for (int i = 0; i < 10; i++) {
		if (val * 10 + i > n) break;
		dfs(val * 10 + i, ar, n);	
	    }
    }
}

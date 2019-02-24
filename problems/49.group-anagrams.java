/*
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (40.62%)
 * Total Accepted:    234.4K
 * Total Submissions: 571.2K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
	HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
	int[] alphabet = new int[26];
	Arrays.fill(alphabet, 0);
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < strs.length; i++) {
	    String str = strs[i];
	    for (char c : str.toCharArray()) {
	   	alphabet[c-'a']++; 
	    }
	    for (int j = 0; j < alphabet.length; j++ ) {
		sb.append("#");
		sb.append(alphabet[j]);
	    }
	    String key = sb.toString();
	    sb = new StringBuilder();
	    if (hm.containsKey(key)) hm.get(key).add(str);
	    else {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(str);
		hm.put(key, ar);
	    }
	    Arrays.fill(alphabet, 0);
	}
	List<List<String>> result = new ArrayList<List<String>>();
	for (List<String> value : hm.values()) {
	    result.add(value);	
	}
	return result;
    }
}

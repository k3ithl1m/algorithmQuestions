/*
 * @lc app=leetcode id=599 lang=java
 *
 * [599] Minimum Index Sum of Two Lists
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 *
 * algorithms
 * Easy (47.27%)
 * Total Accepted:    52.2K
 * Total Submissions: 110K
 * Testcase Example:  '["Shogun","Tapioca Express","Burger King","KFC"]\n["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]'
 *
 * 
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings. 
 * 
 * 
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse",
 * "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is
 * "Shogun" with index sum 1 (0+1).
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 * 
 * 
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
	if (list1.length == 0 || list2.length == 0) return new String[0];
	HashMap<String, Integer> favorite1IndexMap = new HashMap<>();
	for (int i = 0; i < list1.length; i++) {
		favorite1IndexMap.put(list1[i], i);
	}        
	int min = Integer.MAX_VALUE;	
	for (int i = 0; i < list2.length; i++) {
		if (favorite1IndexMap.containsKey(list2[i])) {
			min = Math.min(min, i + favorite1IndexMap.get(list2[i]));
		}
	}
	ArrayList<String> resultList = new ArrayList<>();
	for (int i = 0; i < list2.length; i++) {
		if (favorite1IndexMap.containsKey(list2[i])) {
			if (favorite1IndexMap.get(list2[i]) + i == min) {
				resultList.add(list2[i]);
			}
		}
	}

	String[] result = new String[resultList.size()];
	for (int i = 0; i < resultList.size(); i++) {
		result[i] = resultList.get(i);
	}

	return result;
    }
}

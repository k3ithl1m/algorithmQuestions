/*
 * [726] Number of Atoms
 *
 * https://leetcode.com/problems/number-of-atoms/description/
 *
 * algorithms
 * Hard (43.58%)
 * Total Accepted:    8.4K
 * Total Submissions: 19.3K
 * Testcase Example:  '"H2O"'
 *
 * Given a chemical formula (given as a string), return the count of each
 * atom.
 * 
 * An atomic element always starts with an uppercase character, then zero or
 * more lowercase letters, representing the name.
 * 
 * 1 or more digits representing the count of that element may follow if the
 * count is greater than 1.  If the count is 1, no digits will follow.  For
 * example, H2O and H2O2 are possible, but H1O2 is impossible.
 * 
 * Two formulas concatenated together produce another formula.  For example,
 * H2O2He3Mg4 is also a formula.  
 * 
 * A formula placed in parentheses, and a count (optionally added) is also a
 * formula.  For example, (H2O2) and (H2O2)3 are formulas.
 * 
 * Given a formula, output the count of all elements as a string in the
 * following form: the first name (in sorted order), followed by its count (if
 * that count is more than 1), followed by the second name (in sorted order),
 * followed by its count (if that count is more than 1), and so on.
 * 
 * Example 1:
 * 
 * Input: 
 * formula = "H2O"
 * Output: "H2O"
 * Explanation: 
 * The count of elements are {'H': 2, 'O': 1}.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation: 
 * The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: 
 * formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation: 
 * The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * 
 * 
 * 
 * Note:
 * All atom names consist of lowercase letters, except for the first character
 * which is uppercase.
 * The length of formula will be in the range [1, 1000].
 * formula will only consist of letters, digits, and round parentheses, and is
 * a valid formula as defined in the problem.
 * 
 */
class Solution {
    public String countOfAtoms(String formula) {
	int N = formula.length();
	Stack<TreeMap<String, Integer>> st = new Stack<TreeMap<String, Integer>>();
	st.push(new TreeMap<String, Integer>());
	for (int i = 0; i < N; i++) {
		char c = formula.charAt(i);
		if (c == '(') {
			st.push(new TreeMap<String, Integer>());
		} else if (c == ')') {
			System.out.println(st.size());
			int j = i+1;
			while( j < N && Character.isDigit(formula.charAt(j))) j++;
			int multiplier = Integer.parseInt(formula.substring(i+1, j));
			TreeMap<String, Integer> tm = st.pop();
			System.out.println(st.isEmpty());
			TreeMap<String, Integer> tempTM = st.peek();
			for (String s: tm.keySet()) {
				tempTM.put(s, tempTM.getOrDefault(s,0) + tm.get(s) * multiplier);
			}
		} else if (c <= 'Z' && c >='A') {
			int j = i+1;
			while (j<N && formula.charAt(j) <= 'z' && formula.charAt(j) >= 'a') j++;
			String tempStr = formula.substring(i, j);
			i = j;
			if (j < N && Character.isDigit(formula.charAt(j))) {
				System.out.println(formula.charAt(j));
				while(j< N && Character.isDigit(formula.charAt(j))) j++;
				int tempInt = Integer.parseInt(formula.substring(i, j));
				System.out.println(tempInt);
				st.peek().put(tempStr, st.peek().getOrDefault(tempStr, 0) + tempInt);	
			} else {
				st.peek().put(tempStr, st.peek().getOrDefault(tempStr, 0) + 1);
			}
			i = i - 1;
		}
	}        
	
	TreeMap<String, Integer> hm = st.pop();
	StringBuilder sb = new StringBuilder();
	for (String s: hm.keySet()) {
		sb.append(s);
		if (hm.get(s) > 1) sb.append(hm.get(s));
	}
	return sb.toString();
    }
}

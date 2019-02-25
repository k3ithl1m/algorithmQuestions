/*
 * @lc app=leetcode id=722 lang=java
 *
 * [722] Remove Comments
 *
 * https://leetcode.com/problems/remove-comments/description/
 *
 * algorithms
 * Medium (30.30%)
 * Total Accepted:    13.1K
 * Total Submissions: 43.2K
 *
 * Note:
 * The length of source is in the range [1, 100].
 * The length of source[i] is in the range [0, 80].
 * Every open block comment is eventually closed.
 * There are no single-quote, double-quote, or control characters in the source
 * code.
 * 
 */
class Solution {
    public List<String> removeComments(String[] source) {
	ArrayList<String> resultList = new ArrayList<String>();
	if (source.length == 0) return resultList;
	StringBuilder sb = new StringBuilder();
	boolean blockCommentFound = false;
	for (int i = 0; i < source.length; i++) {
		String currentLine = source[i];
		int foundStartComment = -1;
		boolean foundComment = false;
		int foundStarSymbol = -1;
		for (int j = 0; j < currentLine.length(); j++) {
			if (blockCommentFound) {
				if (currentLine.charAt(j) == '*') {
					foundStarSymbol = j;
					continue;
				} else if (currentLine.charAt(j) == '/') {
					if (foundStarSymbol != -1 && foundStarSymbol + 1 == j) {
						if (j+1 < currentLine.length()) {
							sb.append(currentLine.substring(j+1, currentLine.length()));
						}
						String appendingString = sb.toString();
						if (appendingString.length() > 0) resultList.add(appendingString);
						sb.setLength(0);
						blockCommentFound = false;
					}
				}
				foundStarSymbol = -1;
			}

			if (currentLine.charAt(j) == '*') {
				if (foundStartComment != -1 && foundStartComment + 1 == j) {
					blockCommentFound = true;
					sb.append(currentLine.substring(0, foundStartComment));
					foundComment = true;
				} else foundStartComment = -1;
			} else if (currentLine.charAt(j) == '/') {
				if (foundStartComment != -1 && foundStartComment + 1 == j) {
					String modifiedLine = currentLine.substring(0, foundStartComment);
					if (modifiedLine.length() > 0) resultList.add(modifiedLine);
					foundComment = true;
				} else if (foundStartComment + 1 != j) foundStartComment = -1;
				else foundStartComment = j;
			} 
		}
		if (!foundComment && !blockCommentFound) resultList.add(currentLine);
	}
	return resultList;
    }
}

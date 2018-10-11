/*
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (42.19%)
 * Total Accepted:    64.3K
 * Total Submissions: 152.5K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 */
class Solution {
    public String decodeString(String s) {
      int count = 0;
      Stack<Integer> st1 = new Stack<Integer>();
      Stack<String> st2 = new Stack<String>();
      StringBuilder sb = new StringBuilder();
      String str = "";
      int i = 0;
      while (i < s.length()) {
	char temp = s.charAt(i);
	if (Character.isDigit(temp)) {
	  count = 0;
	  while (Character.isDigit(s.charAt(i))) {
	    count = count * 10;
	    count += Character.getNumericValue(s.charAt(i));
	    i++;
	  }
	  st1.push(count);
	} else if (temp == '[') {
	  st2.push(str);
	  str = "";
	  i++;
	} else if (temp == ']') {
	  StringBuilder temp3 = new StringBuilder(st2.pop());
	  int temp2 = st1.pop();
	  for (int j = 0; j < temp2; j++) {
	    temp3.append(str);
	  } 
	  str = temp3.toString();
	  i++;
	} else {
  	  str = str +temp;	  	
	  i++;
	}
      }    
      return str;
    }
}

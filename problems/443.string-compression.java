/*
 * [443] String Compression
 *
 * https://leetcode.com/problems/string-compression/description/
 *
 * algorithms
 * Easy (35.76%)
 * Total Accepted:    33K
 * Total Submissions: 92.2K
 * Testcase Example:  '["a","a","b","b","c","c","c"]'
 *
 * Given an array of characters, compress it in-place.
 * 
 * The length after compression must always be smaller than or equal to the
 * original array.
 * 
 * Every element of the array should be a character (not int) of length 1.
 * 
 * After you are done modifying the input array in-place, return the new length
 * of the array.
 * 
 * 
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ["a","a","b","b","c","c","c"]
 * 
 * Output:
 * Return 6, and the first 6 characters of the input array should be:
 * ["a","2","b","2","c","3"]
 * 
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by
 * "c3".
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * ["a"]
 * 
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * 
 * Explanation:
 * Nothing is replaced.
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 
 * Output:
 * Return 4, and the first 4 characters of the input array should be:
 * ["a","b","1","2"].
 * 
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed.
 * "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 * 
 * 
 */
class Solution {
    // Have two pointers, one move towards the end
    // the other find the new last position. Then we 
    // can just return the left pointer + 1 to get the 
    // answer. 
    //
    // We loop through the array, if there is a change of character
    // save that into a new temp. and then keep track of the count.
    // when we realize there is a change of character, we keep the 
    // new char, and switch left pointer with the count.
    //
    // //what if it reaches the end?
    // Solution {
    //   -base case
    //   tempChar = chars[0], count = 1, left=0, right =1;
    //   while (right < chars.length) 
    //     if (right equals to tempchar)
    //       count++, continue;
    //     else 
    //       if (count > 1) 
    //          //this two lines have to be in a while loop for the count
    //       	  left++;
    //       	  chars[left] = char of count;
    //       	left++;
    //       	chars[left] = chars[right];
    //       	count = 1;
    //       else 
    //       	left++;
    //       tempChar=chars[right];
    //     right++;
    //   return left+1;
    public int compress(char[] chars) {
	if (chars.length == 1 || chars.length == 0) return chars.length;
	char tempChar = chars[0];
	int count = 1, left = 0, right = 1;
	while (right < chars.length) {
	    if (chars[right] == tempChar) {
		count++;
	    } else {
		if (count > 1) {
		    String strCount = String.valueOf(count);
	 	    for(char c: strCount.toCharArray() ) {
			left++;
			chars[left] = c;
		    }
		}
		left++;
		chars[left]=chars[right];
		count=1;
		tempChar=chars[right];
	    }
	    right++;
	}
	if (count > 1) {
	    String strCount = String.valueOf(count);
 	    for(char c: strCount.toCharArray() ) {
		left++;
		chars[left] = c;
	    }
	}
	return left+1;
    }
}

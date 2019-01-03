/*
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (40.27%)
 * Total Accepted:    134.4K
 * Total Submissions: 332.8K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * 
 * Input: "hello"
 * Output: "holle"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * 
 * 
 */
class Solution {
    public String reverseVowels(String s) {
	if (s.length() <= 0) return s;
	HashSet<Character> hs = new HashSet<Character>();
	hs.add('a');
	hs.add('e');
	hs.add('i');
	hs.add('o');
	hs.add('u');
	hs.add('A');
	hs.add('E');
	hs.add('I');
	hs.add('O');
	hs.add('U');
	char[] chrAr = s.toCharArray();
	int left = 0, right = s.length() -1;        
	while (left < right) {
		while (left < s.length() && !hs.contains(chrAr[left])) left++;
		while (right >= 0 && !hs.contains(chrAr[right])) right--;
		
		if (left < right) {
			char temp = chrAr[left];
			chrAr[left] = chrAr[right];
			chrAr[right] = temp;
		}
		left++;
		right--;
	}
	return String.valueOf(chrAr);
    }

    public static String reverseVowels1(String s) {
        int l = s.length();
        int i=0,j=l-1;
        
        StringBuilder sb = new StringBuilder(s);
        while(i<l && i<=j){
            if(isVowel(sb.charAt(i))){
                if(isVowel(sb.charAt(j))){
                    char temp = sb.charAt(i);
                    sb.setCharAt(i, sb.charAt(j));
                    sb.setCharAt(j, temp);
                    i++;j--;
                }else
                    j--;
            }
            else if(isVowel(sb.charAt(j))){
                i++;
            }
            else{
                i++;j--;
            }
                
        }
        return sb.toString();
    }
    
    public static boolean isVowel(char c){
        char cl = Character.toLowerCase(c);
        if(cl=='a' || cl=='e' || cl=='i' || cl=='o' || cl=='u' )
            return true;
        return false;
    }
}

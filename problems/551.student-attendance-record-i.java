/*
 * [551] Student Attendance Record I
 *
 * https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (44.98%)
 * Total Accepted:    43.9K
 * Total Submissions: 97.6K
 * Testcase Example:  '"PPALLP"'
 *
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).    
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1:
 * 
 * Input: "PPALLP"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "PPALLL"
 * Output: False
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean checkRecord(String s) {
	int count = 0;
	int lateCount = 0;
	for (int i = 0; i < s.length(); i++) {
		char temp = s.charAt(i);
		if (count >= 2) return false;
		if (temp == 'A') {
			count++;
			lateCount = 0;	
		} else if (temp == 'L') {
			if (lateCount >= 2) return false;
			else lateCount++;
		} else {
			lateCount = 0;
		}
	}        
	if (lateCount > 2) return false;
	if (count >1) return false;
	return true;
    }
}

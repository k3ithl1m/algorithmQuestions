import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		String secondLine = sc.nextLine();
		if (firstLine.length() != secondLine.length()) {
			System.out.println("No");
		} else {
			boolean canTransform = true;
			for (int i = 0; i < firstLine.length(); i++) {
				char firstVowel = firstLine.charAt(i);
				char secondVowel = secondLine.charAt(i);
				if (isVowel(firstVowel) == isVowel(secondVowel)) continue;
				else {
					canTransform = false;
					break;
				}
			}		
			if (canTransform ==false) System.out.println("No");
			else System.out.println("Yes");
		}
		sc.close();
	}	

	private static boolean checkAlphabet(char c) {
		if (c <= 'z' && c >= 'a') return true;
		if (c <= 'Z' && c >= 'A') return true;
		return false;
	}

	private static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
		return false;
	}
}

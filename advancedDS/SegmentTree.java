import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int[] numArray = new int[]{1,2,3,4,5,6,7,8,9,10};
		SegmentTree segmentT = new SegmentTree(numArray);
	}

}

class SegmentTree {
	TreeNode root;	
	public SegmentTree(int[] numArray) {
		if (numArray.length == 0) root = new TreeNode(0,0,0);
		else {
			root = populateTree(numArray, 0, numArray.length-1);
		}
	}

	private TreeNode populateTree(int[] numArray, int start, int end) {
		if (start == end) return new TreeNode(start, end, numArray[start]);
		else {
			int mid = start + (end - start) / 2;
			TreeNode next = new TreeNode(start, end, 0);
			next.left = populateTree(numArray, start, mid);
			next.right = populateTree(numArray, mid + 1, end);
			next.val = next.left.val + next.right.val;
			return next;
		}
	}

	public int getValueOfRange(int start, int end) {
		
	}
}

class TreeNode {
	int start;
	int end;
	int val;
	TreeNode left;
	TreeNode right;
	boolean endOfBranch;
	public TreeNode(int start, int end, int val) {
		this.start = start;
		this.end = end;
		this.val = val;
		this.endOfBranch = start == end;
	}
}

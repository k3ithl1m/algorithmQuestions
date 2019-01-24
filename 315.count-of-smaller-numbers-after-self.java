/*
 * [315] Count of Smaller Numbers After Self
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (36.16%)
 * Total Accepted:    62.7K
 * Total Submissions: 173K
 * Testcase Example:  '[5,2,6,1]'
 *
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * 
 * Input: [5,2,6,1]
 * Output: [2,1,1,0] 
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * 
 * 
 */
class Solution {
    public List<Integer> countSmaller2(int[] nums) {
	ArrayList<Integer> finalResult = new ArrayList<>();
	for (int i = 0; i < nums.length; i++) {
		int count = 0;
		for (int j = i+1; j < nums.length; j++) {
			if (nums[j] < nums[i]) count++;	
		}
		finalResult.add(count);
	}        
	return finalResult;
    }

    public List<Integer> countSmaller1(int[] nums) {
	Pair[] pairs = new Pair[nums.length];
	for (int i = 0; i < nums.length; i++) {
		pairs[i] = new Pair(i, nums[i]);
	}
	int[] rCount = new int[nums.length];
	mergesort1(pairs, 0, pairs.length - 1, rCount);
	return Arrays.stream(rCount).boxed().collect(Collectors.toList());
    }

    public void mergesort1(Pair[] nums, int start, int end, int[] rCount) {
	if (start>=end) {
		return;
	}
	int mid = start + (end - start) / 2;
	mergesort1(nums, start, mid, rCount);
	mergesort1(nums, mid+1, end, rCount);
	int j = mid + 1;
	for (int i = start; i <=mid; i++) {
		//skip invalid (not reverted) pair
		while(j<=end && nums[j].value >= nums[i].value) {
			j++;
		} 
		//all numbers from j to end are smaller than num[i];
		// given that the num[i]'s index in original array is nums[i].index
		// we can incement the rCount number accordingly.
		rCount[nums[i].index] += end - j + 1;
	}

	Arrays.sort(nums, start, end+1, (o1,o2) -> o2.value - o1.value);
    }

    int[] count;
	public List<Integer> countSmaller(int[] nums) {
	    List<Integer> res = new ArrayList<Integer>();     

	    count = new int[nums.length];
	    int[] indexes = new int[nums.length];
	    for(int i = 0; i < nums.length; i++){
		indexes[i] = i;
	    }
	    mergesort(nums, indexes, 0, nums.length - 1);
	    for(int i = 0; i < count.length; i++){
		res.add(count[i]);
	    }
	    return res;
	}
	private void mergesort(int[] nums, int[] indexes, int start, int end){
		if(end <= start){
			return;
		}
		int mid = (start + end) / 2;
		mergesort(nums, indexes, start, mid);
		mergesort(nums, indexes, mid + 1, end);
		
		merge(nums, indexes, start, end);
	}
	private void merge(int[] nums, int[] indexes, int start, int end){
		int mid = (start + end) / 2;
		int left_index = start;
		int right_index = mid+1;
		int rightcount = 0;    	
		int[] new_indexes = new int[end - start + 1];

		int sort_index = 0;
		while(left_index <= mid && right_index <= end){
			if(nums[indexes[right_index]] < nums[indexes[left_index]]){
				new_indexes[sort_index] = indexes[right_index];
				rightcount++;
				right_index++;
			}else{
				new_indexes[sort_index] = indexes[left_index];
				count[indexes[left_index]] += rightcount;
				left_index++;
			}
			sort_index++;
		}
		while(left_index <= mid){
			new_indexes[sort_index] = indexes[left_index];
			count[indexes[left_index]] += rightcount;
			left_index++;
			sort_index++;
		}
		while(right_index <= end){
			new_indexes[sort_index++] = indexes[right_index++];
		}
		for(int i = start; i <= end; i++){
			indexes[i] = new_indexes[i - start];
		}
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int value;
	public TreeNode(int value) {
		this.value = value;
	}
}

class Pair {
	int index;
	int value;
	public Pair(int index, int value) {
		this.index = index;
		this.value = value;
	}
} 


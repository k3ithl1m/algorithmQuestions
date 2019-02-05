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
    public List<Integer> countSmaller(int[] nums) {
	if (nums.length == 0) return new ArrayList<Integer>();
	int[] indexStore = new int[nums.length];
	for (int i = 0; i < nums.length; i++) {
		indexStore[i] = i;
	}
	int[] countNumStore = new int[nums.length];
	mergesort(nums, indexStore, new int[nums.length], new int[nums.length], countNumStore, 0, nums.length-1);
	ArrayList<Integer> finalRes = new ArrayList<Integer>();
	for (int i = 0; i < countNumStore.length; i++) {
		finalRes.add(countNumStore[i]);
	}
	return finalRes;
    }

    private void mergesort(int[] nums, int[] indexStore, int[] tempArray, int[] tempIndex, int[] countNumStore, 
		int leftStart, int rightEnd) {
	if (leftStart >= rightEnd) return;
	int middle = leftStart + (rightEnd - leftStart) / 2;
	mergesort(nums, indexStore, tempArray, tempIndex, countNumStore, leftStart, middle);
	mergesort(nums, indexStore, tempArray, tempIndex, countNumStore, middle+1, rightEnd);
	mergeArrayss(nums, indexStore, tempArray, tempIndex, countNumStore, leftStart, rightEnd);
    }

    private void mergeArrays(int[] nums, int[] indexStore, int[] tempArray, int[] tempIndex, int[] countNumStore,
		int leftStart, int rightEnd) {
	int middle = leftStart + (rightEnd - leftStart) / 2;
	int leftEnd = middle, right = middle + 1;
	int left = leftStart, end = rightEnd;
	int index = leftStart;
	int count = 0;
	System.out.println(left + " " + leftEnd + " " + right + " " + rightEnd + " " + nums[index]);
	while (left < leftEnd && right < end) {
		if (nums[right] < nums[left]) {
			System.out.println(nums[right]);
			tempArray[index] = nums[right];
			tempIndex[index] = indexStore[right];
			right++;
			count++;
		} else {
			System.out.println(nums[left]);
			tempArray[index] = nums[left];
			tempIndex[index] = indexStore[left];
//			tempArray[index] = new IndexVal(indexStore[left].index, indexStore[left].value);
			countNumStore[indexStore[left++]] += count;
		}
		index++;
	}

	while (left <= leftEnd) {
		tempIndex[index] = indexStore[left];
		tempArray[index++] = nums[left];
		countNumStore[indexStore[left++]] += count;
	}
	while (right < rightEnd) {
		tempIndex[index] = indexStore[right];
		tempArray[index++] = nums[right++];
	}
	
	index = leftStart;
	while(index < rightEnd) {
		nums[index] = tempArray[index];
		indexStore[index] = tempIndex[index];
		index++;	
	}
    }

    private void mergeArrayss(int[] nums, int[] indexStore, int[] tempArray, int[] tempIndex, int[] countNumStore,
		int leftStart, int rightEnd) {
	int middle = leftStart + (rightEnd - leftStart) / 2;
	int size = rightEnd - leftStart + 1;
	int leftEnd = middle, right = middle + 1;
	int left = leftStart, end = rightEnd;
	int index = leftStart;
	int count = 0;
	while(left <= leftEnd && right <= rightEnd) {
		if (nums[right] < nums[left]) {
			tempArray[index] = nums[right];
			tempIndex[index] = indexStore[right];
			right++;
			count++;
		} else {
			tempArray[index] = nums[left];
			tempIndex[index] = indexStore[left];
			countNumStore[indexStore[left++]] += count;
		}
		index++;
	}	

	while(left<=leftEnd) {
		tempIndex[index] = indexStore[left];
		tempArray[index] = nums[left];
		countNumStore[indexStore[left]] += count;
		index++;
		left++;
	}

	while(right<=rightEnd) {
		tempIndex[index] = indexStore[right];
		tempArray[index] = nums[right];
		index++;
		right++;
	}

	for (int i = leftStart; i <= end; i++) {
		nums[i] = tempArray[i];
		indexStore[i] = tempIndex[i];
	}

//	System.arraycopy(nums, left, tempArray, index, leftEnd - left + 1);
//	System.arraycopy(nums, right, tempArray, index, rightEnd - right + 1);
//	System.arraycopy(tempArray, leftStart, nums, leftStart, size);
    }
}

class IndexVal {
	int index;
	int value;
	public IndexVal(int index, int value) {
		this.index = index;
		this.value = value;
	}
}

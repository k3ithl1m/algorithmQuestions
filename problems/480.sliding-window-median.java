/*
 * [480] Sliding Window Median
 *
 * https://leetcode.com/problems/sliding-window-median/description/
 *
 * algorithms
 * Hard (30.72%)
 * Total Accepted:    19.4K
 * Total Submissions: 62.9K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5 
 * 
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Your job is to output the median array for each window in the
 * original array.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * 
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * ⁠1 [3  -1  -3] 5  3  6  7       -1
 * ⁠1  3 [-1  -3  5] 3  6  7       -1
 * ⁠1  3  -1 [-3  5  3] 6  7       3
 * ⁠1  3  -1  -3 [5  3  6] 7       5
 * ⁠1  3  -1  -3  5 [3  6  7]      6
 * 
 * 
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * 
 * Note: 
 * You may assume k is always valid, ie: k is always smaller than input array's
 * size for non-empty array.
 */
class Solution {
   

    public double[] medianSlidingWindow(int[] nums, int k) {
	if (nums.length == 0) return new double[0];
	PriorityQueue
    }


    public double[] medianSlidingWindow2(int[] nums, int k) {
	PriorityQueue<Integer> lowerBound = new PriorityQueue<Integer>(Collections.reverseOrder());
	PriorityQueue<Integer> upperBound = new PriorityQueue<Integer>();
	for (int i = 0; i < k; i++) {
		lowerBound.offer(nums[i]);
	}        
	ArrayList<Double> finalResult = new ArrayList<Double>();
	boolean isOdd = (k % 2 == 1);
	for (int i = 0; i < k/2; i++) {
		upperBound.offer(lowerBound.poll());
	}
	if (isOdd) finalResult.add(lowerBound.peek()/1.0);
	else finalResult.add(lowerBound.peek()/2.0 + upperBound.peek()/ 2.0);

	for (int i=0; i < nums.length - k; i++) {
		lowerBound.offer(nums[k+i]);
		upperBound.offer(lowerBound.poll());
		if (lowerBound.contains(nums[i])) {
			lowerBound.remove(nums[i]);
			lowerBound.offer(upperBound.poll());
		} else {
			upperBound.remove(nums[i]);
		}

		if (isOdd) finalResult.add(lowerBound.peek()/1.0);
		else finalResult.add(lowerBound.peek()/2.0 + upperBound.peek()/2.0);
	}

	double[] result = new double[finalResult.size()];
	for (int i = 0; i < finalResult.size(); i++) {
		result[i] = finalResult.get(i);
	}
	return result;
    }

   public double[] medianSlidingWindow2(int[] nums, int k) {
    if (k == 0) return new double[0];
    double[] ans = new double[nums.length - k + 1];
    int[] window = new int[k];
    for (int i = 0; i < k; ++i) 
      window[i] = nums[i];
    Arrays.sort(window);
    for (int i = k; i <= nums.length; ++i) {
      ans[i - k] = ((double)window[k / 2] + window[(k - 1)/2]) / 2;
      if (i == nums.length) break;
      remove(window, nums[i - k]);
      insert(window, nums[i]);
    }
    return ans;
  }
  
  // Insert val into window, window[k - 1] is empty before inseration
  private void insert(int[] window, int val) {
    int i = Arrays.binarySearch(window, val);
    if (i < 0) i = - i - 1;    
    int j = window.length - 1;
    while (j > i) window[j] = window[--j];
    window[j] = val;
  }
  
  // Remove val from window and shrink it.
  private void remove(int[] window, int val) {
    int i = Arrays.binarySearch(window, val);
    while (i < window.length - 1) window[i] = window[++i];
  }
}

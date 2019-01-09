/*
 * [295] Find Median from Data Stream
 *
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (33.13%)
 * Total Accepted:    84.2K
 * Total Submissions: 251.6K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]'
 *
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * For example,
 * 
 * [2,3,4], the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure.
 * double findMedian() - Return the median of all elements so far.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * If all integer numbers from the stream are between 0 and 100, how would you
 * optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how
 * would you optimize it?
 * 
 * 
 */
class MedianFinder {

    int count;
    PriorityQueue<Integer> pq2;
    PriorityQueue<Integer> pq1;

    /** initialize your data structure here. */
	//the max heap contains the front one.
	// the min heap contains the second half
    public MedianFinder() {
	pq2 = new PriorityQueue<Integer>(); 
	pq1 = new PriorityQueue<Integer>(Collections.reverseOrder()); 
    }
    
	//we add the number to the front heap. We then move
	//one from the front heap to the back heap.
	//we check the size of both heap and move it to make it equal
	//or at least make the second half one bigger.
    public void addNum(int num) {
	pq1.offer(num);
	pq2.offer(pq1.poll());
	if (pq2.size() - pq1.size() > 1) pq1.offer(pq2.poll());
    }
   
	// if both of the size is the same size, then we peek from both and
	// get the average of it. Else, take the bigger size one. 
    public double findMedian() {
	if (pq1.size() == pq2.size()) {
		int temp1 = pq1.peek();
		int temp2 = pq2.peek();
		double res = (temp1 + temp2) / 2.0;
		System.out.println(temp1 + " " + temp2);
		return res;
	} else if (pq1.size() > pq2.size()) {
		return pq1.peek();
	} else {
		return pq2.peek();
	}	
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

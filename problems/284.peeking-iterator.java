/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 *
 * https://leetcode.com/problems/peeking-iterator/description/
 *
 * algorithms
 * Medium (38.49%)
 * Total Accepted:    67.5K
 * Total Submissions: 175.4K
 * Testcase Example:  '["PeekingIterator","next","peek","next","next","hasNext"]\n[[[1,2,3]],[],[],[],[],[]]'
 *
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 * 
 * Example:
 * 
 * 
 * Assume that the iterator is initialized to the beginning of the list:
 * [1,2,3].
 * 
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2. 
 * You call next() the final time and it returns 3, the last element. 
 * Calling hasNext() after that should return false.
 * 
 * 
 * Follow up: How would you extend your design to be generic and work with all
 * types, not just integer?
 * 
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

//	private Queue<Integer> store;
	private Iterator<Integer> store2;
	private Integer nextVal;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
//		store = new LinkedList<Integer>();
//		while(iterator.hasNext()) {
//			store.add(iterator.next());
//		}
		store2 =iterator; 
		if (store2 != null && store2.hasNext()) {
			nextVal = store2.next();
		}
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
 //      		return store.peek(); 
		return nextVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
//	   return store.remove(); 
	   Integer result = nextVal;
	   nextVal = store2.hasNext()?store2.next(): null;
	   return result;
	}

	@Override
	public boolean hasNext() {
//	   return !store.isEmpty(); 
	   return (nextVal != null) ? true : false;
	}
}

/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 *
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 *
 * algorithms
 * Medium (46.16%)
 * Total Accepted:    93.3K
 * Total Submissions: 202.1K
 * Testcase Example:  '[[1,1],2,[1,1]]'
 *
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns
 * false, 
 * the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns
 * false, 
 * the order of elements returned by next should be: [1,4,6].
 * 
 * 
 * 
 * 
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    Stack<List<NestedInteger>> nestedIntegerTracker;
    Stack<Integer> positionOfNestedInteger;
    public NestedIterator(List<NestedInteger> nestedList) {
       	nestedIntegerTracker = new Stack<List<NestedInteger>>();
	positionOfNestedInteger = new Stack<Integer>(); 
	nestedIntegerTracker.push(nestedList);
	positionOfNestedInteger.push(0);
    }

    @Override
    public Integer next() {
	List<NestedInteger> currentNestedIntegerList = nestedIntegerTracker.peek();
	int currentPosition = positionOfNestedInteger.peek();
	NestedInteger currentNestedInteger = currentNestedIntegerList.get(currentPosition);
	boolean isInteger = currentNestedInteger.isInteger();

	while (!isInteger) {
		positionOfNestedInteger.pop();
		if (currentPosition+1 >= currentNestedIntegerList.size()) {
			nestedIntegerTracker.pop();
		} else positionOfNestedInteger.push(currentPosition+1);
		nestedIntegerTracker.push(currentNestedInteger.getList());
		currentPosition = 0;
		positionOfNestedInteger.push(currentPosition);
		currentNestedIntegerList = nestedIntegerTracker.peek();
		currentNestedInteger = currentNestedIntegerList.get(currentPosition);
		isInteger = currentNestedInteger.isInteger();
	}

	Integer toReturn = currentNestedIntegerList.get(currentPosition).getInteger();
	positionOfNestedInteger.pop();
	if (currentPosition + 1 >= currentNestedIntegerList.size()) {
		nestedIntegerTracker.pop();
	} else positionOfNestedInteger.push(currentPosition + 1);
	System.out.println(toReturn);
	return toReturn;
    }

    @Override
    public boolean hasNext() {
       	if (!nestedIntegerTracker.isEmpty()) return true;
	return false; 
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

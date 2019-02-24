/*
 * [232] Implement Queue using Stacks
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * algorithms
 * Easy (40.33%)
 * Total Accepted:    124.2K
 * Total Submissions: 307.9K
 * Testcase Example:  '["MyQueue","push","push","peek","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement the following operations of a queue using stacks.
 * 
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * 
 * Example:
 * 
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a stack -- which means only push to
 * top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may
 * simulate a stack by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek
 * operations will be called on an empty queue).
 * 
 * 
 */
class MyQueue {

    private Stack<Integer> st;
    /** Initialize your data structure here. */
    public MyQueue() {
       st = new Stack<Integer>(); 
    }
    
    /** Push element x to the back of queue. */
    // the stacks are different from the queues because
    // it changes the order every time you pop it out
    // - So you just FREAKING Reverse the orders
    public void push(int x) {
       Stack<Integer> temp = new Stack<Integer>();
       	while(!st.isEmpty()) {
	    int val = st.pop();
	    System.out.println(val);
	    temp.push(val);
	}
       temp.push(x);
       	while(!temp.isEmpty()) {
	    int val = temp.pop();
	    System.out.println(val);
	    st.push(val);
	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       return st.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       return st.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
       return st.isEmpty(); 
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

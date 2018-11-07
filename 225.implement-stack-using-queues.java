/*
 * [225] Implement Stack using Queues
 *
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (36.42%)
 * Total Accepted:    109.1K
 * Total Submissions: 299.4K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement the following operations of a stack using queues.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * 
 * Example:
 * 
 * 
 * MyStack stack = new MyStack();
 * 
 * stack.push(1);
 * stack.push(2);  
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 * 
 * 
 */
class MyStack {

    private Queue<Integer> q1;
    /** Initialize your data structure here. */
    public MyStack() {
       q1 = new LinkedList<Integer>(); 
    }
    
    /** Push element x onto stack. */
    // this is the tough part. I started by using two stacks
    // and whenever i push a new value, I have to access the 
    // other one and enqueue everything into the new one.
    // and then set a pointer to point towards the new one. 
    // But for that I got time limit exceeded. 
    //
    // This one the concept is the same but it is so much faster
    // We can either self dequeue and enqueue, which for some reason is slower
    // or we can just create the temporary one and dequeue everything from the
    // old one.
    public void push(int x) {
	Queue<Integer> temp = new LinkedList<>();
	temp.add(x);
	while(!q1.isEmpty()) {
	     temp.add(q1.poll());	
	}
	q1 = temp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
       return q1.peek(); 
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
       return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

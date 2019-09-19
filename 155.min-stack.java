/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (36.47%)
 * Total Accepted:    287.8K
 * Total Submissions: 789.2K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 */
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st = new Stack();
    Stack<Integer> minst = new Stack(); 
    public MinStack() {
               
    }
    
    public void push(int x) {
        st.push(x);
        if(minst.isEmpty() || x < minst.peek()){
            minst.push(x);
        }
        else
        minst.push(minst.peek());
    }
    
    public void pop() {
        st.pop();
        minst.pop();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        else return st.peek();
    }
    
    public int getMin() {
        if(minst.isEmpty()) return -1;
        else return minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


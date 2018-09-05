class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> tempt;
    int peek;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
        tempt = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty()) peek = x;
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stack.size() > 1) {
            peek = stack.pop();
            tempt.push(peek);
        }
        int poped = stack.pop();
        while (!tempt.isEmpty()) {
            stack.push(tempt.pop());
        }
        return poped;
    }
    
    /** Get the front element. */
    public int peek() {
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
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

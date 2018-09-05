class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q;
    Queue<Integer> tempt;
    int top;
    public MyStack() {
        q = new LinkedList<Integer>();
        tempt = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        q.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q.size() > 1) {
            top = q.poll();
            tempt.add(top);
        }
        int result = q.poll();
        Queue<Integer> cache = q;
        q = tempt;
        tempt = cache;
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
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

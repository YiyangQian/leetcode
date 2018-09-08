class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> q;
    int maxSize;
    int sum;
    public MovingAverage(int size) {
        q = new LinkedList<Integer>();
        maxSize = size;
        sum = 0;
    }
    
    public double next(int val) {
        if (q.size() == maxSize) {
            int polled = q.poll();
            q.add(val);
            sum = sum - polled + val;
            return sum * 1.0 / maxSize;
        } else {
            q.add(val);
            sum += val;
            return sum * 1.0 / q.size();
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
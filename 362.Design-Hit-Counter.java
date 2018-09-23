class HitCounter {

    /** Initialize your data structure here. */
    Queue<Hit> q;
    int sum;
    public HitCounter() {
        q = new LinkedList<Hit>();
        sum = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        updateQ(timestamp);
        if (q.size() >= 1 && q.peek().time == timestamp) {
            q.peek().count++;
        } else {
            q.add(new Hit(timestamp));
        }
        sum += 1;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        updateQ(timestamp);
        return sum;
    }
    
    public void updateQ(int timestamp) {
        while (q.size() >= 1 && q.peek().time <= timestamp - 300) {
            Hit polled = q.poll();
            sum -= polled.count;
        }
    }
}

class Hit {
    int time;
    int count;
    Hit(int timeStamp) {
        time = timeStamp;
        count = 1;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
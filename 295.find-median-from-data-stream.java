import java.util.PriorityQueue;

/*
 * [295] Find Median from Data Stream
 *
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (30.67%)
 * Total Accepted:    106.4K
 * Total Submissions: 292.1K
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

    // lo is a max heap    max value of lo is no larger than min value of hi
    // hi is a min heap    size(hi) <= size(lo) <= size(hi) + 1
    private PriorityQueue<Integer> lo;
    private PriorityQueue<Integer> hi;

    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<>((Integer a, Integer b) -> b - a);
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());
        if (hi.size() > lo.size()) {
            lo.add(hi.poll());
        }
    }
    
    public double findMedian() {
        return lo.size() == hi.size() ? (lo.peek() + hi.peek()) / 2.0 : lo.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

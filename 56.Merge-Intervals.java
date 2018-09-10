/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((Interval a, Interval b) -> a.start - b.start);
        List<Interval> res = new LinkedList<Interval>();
        if (intervals.size() == 0) return res;
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (cur.end >= next.start) {
                cur.end = Math.max(next.end, cur.end);
            } else {
                res.add(cur);
                cur = next;
            }
        }
        res.add(cur);
        return res;
    }
}
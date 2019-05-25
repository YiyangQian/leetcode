/*
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (15.74%)
 * Total Accepted:    119.3K
 * Total Submissions: 757.3K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                long dx = points[i][0] - points[j][0];
                long dy = points[i][1] - points[j][1];
                boolean isVertical = false;
                if (dx == 0) isVertical = true;
                long dx_times_b = points[i][1] * dx - points[i][0] * dy;

                int count = 0;
                for (int k = 0; k < points.length; k++) {
                    if (isVertical) {
                        if (points[k][0] == points[i][0]) count++;
                    } else {
                        if (dx * points[k][1] - dy * points[k][0] == dx_times_b) count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}

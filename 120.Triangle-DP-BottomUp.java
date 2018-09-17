class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int cur = triangle.get(i).get(j);
                cur = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + cur;
                triangle.get(i).set(j, cur);
            }
        }
        return triangle.get(0).get(0);
    }
}

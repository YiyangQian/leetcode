class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        helper(res, n, k, cur, 0, 1);
        return res;
    }
    
    public void helper(List<List<Integer>> res, int n, int k, List<Integer> cur, int track, int start) {
        if (track == k) {
            res.add(new LinkedList<Integer>(cur));
        } else {
            for (int i = start; i <= n; i++) {
                if (!cur.contains(i)) {
                    cur.add(i);
                    helper(res, n, k, cur, track + 1, i + 1);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //i in this level can go to i and i + 1 in next level
        List<Integer> preLevel = new LinkedList<Integer>();
        List<Integer> curLevel = new LinkedList<Integer>();
        preLevel.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                if (j == 0) {
                    curLevel.add(preLevel.get(0) + cur.get(0));
                } else if (j == cur.size() - 1) {
                    curLevel.add(preLevel.get(j - 1) + cur.get(j));
                } else {
                    curLevel.add(Math.min(preLevel.get(j - 1), preLevel.get(j)) + cur.get(j));
                }
            }
            preLevel = curLevel;
            curLevel = new LinkedList<Integer>();
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < preLevel.size(); i++) {
            res = Math.min(res, preLevel.get(i));
        }
        return res;
    }
}

 //        2
 //      5   6
 //    11  10  13
 // 15    11  18  16
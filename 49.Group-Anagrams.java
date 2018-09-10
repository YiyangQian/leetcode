class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] toBeSorted = strs[i].toCharArray();
            Arrays.sort(toBeSorted);
            String cur = String.valueOf(toBeSorted);
            if (map.containsKey(cur)) {
                map.get(cur).add(strs[i]);
            } else {
                List<String> l = new LinkedList<String>();
                l.add(strs[i]);
                map.put(cur, l);
            }
        }
        List<List<String>> res = new LinkedList<List<String>>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
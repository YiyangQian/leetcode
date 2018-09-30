class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        if (s.length() <= 10) {
            return res;
        } 
        int hash = 0;
        int d = 256;
        int q = 101;
        int h = 1;
        for (int i = 0; i < 9; i++) {
            h = (h * d) % q; 
        }
        
        for (int i = 0; i < 10; i++) {
            hash = (hash * d + s.charAt(i)) % q;
        }
        //key is hash value, value is SET of string
        Map<Integer, Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add(s.substring(0, 10));
        map.put(hash, set);
        for (int i = 10; i < s.length(); i++) {
            hash = hash - (s.charAt(i - 10) * h) % q;
            hash = (hash * d + s.charAt(i)) % q;
            if (hash < 0) hash += q;

            if (map.containsKey(hash)) {
                if (map.get(hash).contains(s.substring(i - 9, i + 1))) {
                    if (!res.contains(s.substring(i - 9, i + 1))) res.add(s.substring(i - 9, i + 1));
                } else {
                    map.get(hash).add(s.substring(i - 9, i + 1));
                }
            } else {
                Set<String> cur = new HashSet<>();
                cur.add(s.substring(i - 9, i + 1));
                map.put(hash, cur);
            }
        }
        return res;
    }
}

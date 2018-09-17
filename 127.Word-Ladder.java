class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> toVisit = new HashSet<String>(wordList);
        if (!toVisit.contains(endWord)) return 0;
        int level = 0;
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        q.add(null);
        String cur = null;
        while(!(q.size() == 1 && cur == null)) {
            cur = q.poll();
            if (cur == null) {
                level++;
                q.add(null);
            } else {
                if (cur.equals(endWord)){
                    return level + 1;
                } else {
                    toVisit.remove(cur);
                    List<String> nextLevel = getNextLevel(toVisit, cur);
                    if (nextLevel.size() != 0) {
                        for (String s : nextLevel) {
                            q.add(s);
                            toVisit.remove(s);
                        }
                    }
                 }
            }
        }
        return 0;
    }
    
    public List<String> getNextLevel(Set<String> set, String cur) {
        List<String> res = new LinkedList<String>();
        for (String s: set) {
            if (distanceIsOne(s, cur)) {
                res.add(s);
            }
        }
        return res;
    }
    
    public boolean distanceIsOne(String a, String b) {
        if (a.length() != b.length()) return false;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }
}

class Solution {
    public boolean isStrobogrammatic(String num) {
        //180 means reverse order and have a certain mapping
        Map<Character, Character> map = new HashMap<Character, Character>();
        boolean res = true;
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            if (map.containsKey(cur)) {
                res = res && map.get(cur) == num.charAt(num.length() - 1 - i);
                if (res == false) return false;
            } else {
                return false;
            }
        }
        return res;
    }
}
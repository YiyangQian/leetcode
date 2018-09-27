class Solution {
    public String largestNumber(int[] nums) {
        String[] numsInString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsInString[i] = "" + nums[i];
        }
        Arrays.sort(numsInString, new compareTwoString());
        if (numsInString[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(numsInString[i]);
        }
        return sb.toString();
    }
}

class compareTwoString implements Comparator<String> {
    public int compare(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;
        return order2.compareTo(order1);
    }
}

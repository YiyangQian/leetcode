class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> res = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] resInArray = new int[res.size()];
        int index = 0;
        for (Integer x : res) {
            resInArray[index++] = x;
        }
        return resInArray;
    }
}
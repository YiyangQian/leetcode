class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> l = new LinkedList<Integer>();
        int p = 0, q = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] < nums2[q]) {
                p++;
            } else if (nums1[p] > nums2[q]) {
                q++;
            } else {
                l.add(nums1[p]);
                p++;
                q++;
            }
        }
        int[] res = new int[l.size()];
        int index = 0;
        for (int cur : l) res[index++] = cur;
        return res;
    }
}

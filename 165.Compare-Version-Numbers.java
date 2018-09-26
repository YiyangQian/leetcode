class Solution {
    public int compareVersion(String version1, String version2) {
        String[] cutted1 = version1.split("\\.");
        String[] cutted2 = version2.split("\\.");
        int p1 = 0, p2 = 0;
        while (p1 != cutted1.length && p2 != cutted2.length) {
            int num1 = Integer.parseInt(cutted1[p1]);
            int num2 = Integer.parseInt(cutted2[p2]);
            
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            p1++;
            p2++;
        }
        if (p1 < cutted1.length) {
            for (int i = p1; i < cutted1.length; i++) {
                if (Integer.parseInt(cutted1[i]) > 0) {
                    return 1;
                }
            }
        }
        if (p2 < cutted2.length) {
            for (int i = p2; i < cutted2.length; i++) {
                if (Integer.parseInt(cutted2[i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}

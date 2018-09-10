class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int cur = (num1.charAt(num1.length() - 1 - i) - '0') * (num2.charAt(num2.length() - 1 - j) - '0');
                res[res.length - 1 - i - j] += cur;
            }
        }
        int carry = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            int sum = res[i] + carry;
            res[i] = sum % 10;
            carry = sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < res.length && res[start] == 0) start++;
        if (start == res.length) return "0";
        for (int i = start; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}

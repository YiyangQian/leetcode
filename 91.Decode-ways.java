class Solution {
    public int numDecodings(String s) {
        int[] track = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) - '0' == 0) {
                    return 0;
                } else {
                    track[i] = 1;
                }
            } else {
                int two = s.charAt(i - 1) - '0';
                int one = s.charAt(i) - '0';
                if (one == 0 && (two == 1 || two == 2)) {
                    track[i] = (i >= 2) ? track[i - 2] : 1;
                } else if (one == 0) {
                    track[i] = 0;
                } else {
                    if (i >= 2) {
                        track[i] = (two * 10 + one <= 26 && two != 0) ? track[i - 1] + track[i - 2] : track[i - 1];               
                    } else {
                        track[i] = (two * 10 + one <= 26) ? track[i - 1] + 1 : track[i - 1];                    
                    }
                }
            }
        }
        return track[track.length - 1];
    }
}

//case 1: 0 being the first number, return 0;
//case 2: cur number is 0, and former is 1 or two
//case 3: cur number is 0, and former is neither 0 or 1;
//case 4: cur number is not 0, and former is not 0;
//case 5: cur number is not 0, and former is 0;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            return helper(1, n);
        }
        
        public int helper(int p, int q)  {
            if (p == q) return p;
            // int mid = (p + q) / 2;
            int mid = p + (q - p) / 2;
            if (isBadVersion(mid)) return helper(p, mid);
            return helper(mid + 1, q);
        }
    }
    
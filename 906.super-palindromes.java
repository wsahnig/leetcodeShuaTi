/*
 * @lc app=leetcode id=906 lang=java
 *
 * [906] Super Palindromes
 */

// @lc code=start
class Solution {
        public int superpalindromesInRange(String sL, String sR) {
            long L = Long.valueOf(sL);
            long R = Long.valueOf(sR);
            int MAGICFORODD = 100000;
            int MAGICFOREVEN = 10000;
            int ans = 0;
    
            // count odd length;
            for (int k = 1; k < MAGICFORODD; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 2; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R) break;
                if (v >= L && isPalindrome(v)) ans++;
            }
    
            // count even length;
            for (int k = 1; k < MAGICFOREVEN; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 1; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if(v > R) break;
                if (v >= L && isPalindrome(v)) ans++;
            }
    
            return ans;
        }
    
        private boolean isPalindrome(long x) {
            String s = String.valueOf(x);
            return s.equals(new StringBuilder(s).reverse().toString());
        }
}
// @lc code=end


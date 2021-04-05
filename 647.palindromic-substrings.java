/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extendPalindrome(s, i, i);//odd length
            count += extendPalindrome(s, i, i + 1);//even length
        }
        return count;
    }

    private int extendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
// @lc code=end


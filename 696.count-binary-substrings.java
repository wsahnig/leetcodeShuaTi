/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0,pre = 0,cur = 1, n = s.length();
        for(int i=1; i<n; i++)
        {
            if(s.charAt(i) == s.charAt(i-1)) cur++;
            else
            {
                pre = cur;
                cur = 1;
            }
            if(pre >= cur) res++;
        }
        return res;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=1461 lang=java
 *
 * [1461] Check If a String Contains All Binary Codes of Size K
 */

// @lc code=start
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<String>();

        for (int i = k; i <= s.length(); i++) {
            String a = s.substring(i - k, i);
            if (got.add(a)) {
                
                need--;
                // return true when found all occurrences
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end


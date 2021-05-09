/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0; i<words.length-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            if(s1.equals(s2)) continue;
            if(s1.indexOf(s2) != -1)
                return false;
            if(s2.indexOf(s1) != -1)
                continue;
            int len = s1.length();
            int len2 = s2.length();
            len = Math.min(len,len2);
            for(int j=0;j<len;j++){
                int c1 = order.indexOf(s1.charAt(j));
                int c2 = order.indexOf(s2.charAt(j));
                if(c1 > c2) return false;
                if(c1 < c2) break;
            }
        }
        return true;
    }
}
// @lc code=end


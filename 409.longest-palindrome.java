import java.util.Map;

/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        Map<Character,Integer> hm = new HashMap();
        for(int i=0;i<len;i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0)+1);
        }
        int sum = 0;
        for(Character key : hm.keySet()){
            sum += hm.get(key) / 2 * 2;
        }
        sum += len==sum ? 0 : 1;
        return sum;
    }
}
// @lc code=end


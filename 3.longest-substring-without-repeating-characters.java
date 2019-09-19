/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (27.97%)
 * Total Accepted:    818.9K
 * Total Submissions: 2.9M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, t = 0, len = s.length();

        for (int i = 0; i < len; i++) {
            int[] hash = new int[130];
            t = 1;
            
            hash[(int) s.charAt(i)] = 1;
            for (int j = i + 1; j < len; j++) {
                
                if (hash[(int) s.charAt(j)] == 0) {
                    hash[(int) s.charAt(j)] = 1;
                    t = t + 1;
                } else {
                    break;
                }
            }
            if (t > max)
            max = t;
        }
        return max;
    }
}

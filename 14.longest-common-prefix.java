/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.04%)
 * Total Accepted:    417.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
       String ans ="";
       int l = Integer.MAX_VALUE,i=0,j=0;
       if(strs.length == 0) return ans;
       for(i=0;i<strs.length;i++){
           if(strs[i].length() < l)
             l = strs[i].length();
       }
       for(i=0;i<l;i++){
           char x = strs[0].charAt(i);
           for(j=1;j<strs.length;j++){
               if(strs[j].charAt(i) != x) break;
           }
           if(j == strs.length) ans += x;
           else return ans;
       }
       return ans; 
    }
}


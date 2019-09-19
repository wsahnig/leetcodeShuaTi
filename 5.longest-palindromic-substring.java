/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.65%)
 * Total Accepted:    487.6K
 * Total Submissions: 1.8M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    int max = 0;
    String ans = "";
    public String longestPalindrome(String s) {
        for(int i=0;i< s.length();i++){
            checkPalindrome(i,i,s);//odd
            checkPalindrome(i,i+1,s);//even
        }
        return ans;
    }
    public void checkPalindrome(int low,int high,String s){
       while( low >=0 && high < s.length()){
           if(s.charAt(low) == s.charAt(high)){
            
              if(high - low + 1 > max) {
                  max = high - low + 1;
                  ans = s.substring(low, high+1);
              }
              low--;
              high++;
           }
           else{ return;}
       }
    }
}


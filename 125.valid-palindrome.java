/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (30.63%)
 * Total Accepted:    341.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if("".equals(s)) return true;
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
              sb.append(s.charAt(i));
        }
        String s1 = sb.toString();
        return sb.reverse().toString().equals(s1);
    }
}


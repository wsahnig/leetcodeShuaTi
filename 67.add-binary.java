/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (38.20%)
 * Total Accepted:    282.6K
 * Total Submissions: 739.7K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
       int i=a.length()-1 , j=b.length()-1 , tmp = 0 ,x=0 ,y=0;
       char z = '0';
       String ans = "";
       while(i >= 0 && j >= 0){
            x = a.charAt(i--)-'0';
            y = b.charAt(j--)-'0';
            z = (char)((x + y + tmp) % 2+'0');
           tmp = (x + y + tmp) / 2;
           ans = ans + z;
       }
       while(i >= 0){
          x = a.charAt(i--)-'0'; 
          z =(char) ((x + tmp) % 2+'0');
          tmp = (x + tmp) / 2;
          ans = ans + z;
       }
       while(j >= 0){
          x = b.charAt(j--)-'0'; 
          z =(char) ((x + tmp) % 2+'0');
          tmp = (x + tmp) / 2;
          ans = ans + z;
       }
       if(tmp == 1)
        ans = ans + '1';       
        
        return new StringBuilder(ans).reverse().toString();
    }
}


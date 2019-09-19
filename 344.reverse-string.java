/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */
class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i=0;i<len/2;i++){
            char t = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = t;
        }
    }
}


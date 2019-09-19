/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */
class Solution {
    public int titleToNumber(String s) {
        int number = 0;
        for(int i=0;i<s.length();i++){
            number *= 26;
            number += s.charAt(i) - 'A' + 1;
        }
        return number;
    }
}


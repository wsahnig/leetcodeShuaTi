/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.80%)
 * Total Accepted:    363K
 * Total Submissions: 889.7K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int i=0;
        for(i=0;i < digits.length;i++){
            if(digits[i] != 9) break;
        }
        if(i == digits.length){
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            while(i > 0){
                ans[i] = 0;
                i--;
            }
            return ans;
        }
        i = digits.length - 1;
        while(digits[i] + 1 == 10){
            digits[i] = 0;
            i --;
        }
        digits[i]++;
        return digits;
    }
}


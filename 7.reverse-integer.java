/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.14%)
 * Total Accepted:    618K
 * Total Submissions: 2.5M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE , min = Integer.MIN_VALUE;
        int ans = 0;
        while(x != 0){
            if(min / 10 > ans || max / 10 < ans) return 0;
            ans *= 10;                       
        	if( (x>0 && max-x % 10 < ans) || (x<0 && min - x % 10 > ans) ) return 0;               
            ans += x % 10;
            x = x / 10; 
        }
        return ans;
    }
}

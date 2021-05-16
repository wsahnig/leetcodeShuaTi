/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        int x=0;
        int y=1;
        if(n==0) return x;
        if(n==1) return y;
        for(int i=2;i<=n;i++)
        {
            int tmp = x;
            x = y;
            y += tmp; 
        }
        return y;
    }
}
// @lc code=end


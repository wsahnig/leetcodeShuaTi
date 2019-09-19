/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        //dp[1]为最小值
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                int tmp = 
                Math.max(dp[j],j)*Math.max(dp[i-j],i-j);
                if(tmp > dp[i]){
                    dp[i] = tmp;
                }
            }
        }
        return dp[n];
    }
}


/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length,ans=0;
        int dp[]=new int[n];
        int num=prices[n-1];
        for(int i=n-2;i>=0;i--)
        {
            dp[i]=Math.max(dp[i+1],num-prices[i]);
            num=Math.max(num,prices[i]);
            ans=Math.max(ans,dp[i]);
        }
        num=prices[0];
        for(int i=1;i<n-1;i++)
        {
            ans=Math.max(ans,prices[i]-num+dp[i+1]);
            num=Math.min(num,prices[i]);
        }
        return ans;
    }
}
// @lc code=end


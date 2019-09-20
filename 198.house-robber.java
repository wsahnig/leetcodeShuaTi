/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        if(len > 2) dp[2] = nums[2] + dp[0];
        for(int i=3;i<len;i++){
            dp[i] = nums[i] + Math.max(dp[i-3],dp[i-2]);
        }
        return Math.max(dp[len-1],dp[len-2]);
    }
}


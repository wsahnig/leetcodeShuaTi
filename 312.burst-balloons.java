/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
       int[][] dp = new int[nums.length][nums.length];
       for(int i=0;i<nums.length;i++){
           Arrays.fill(dp[i], -1);
       }
       return coins(nums, 0, nums.length-1, dp);
    }
    public int coins(int[] nums, int left, int right, int[][] dp) {
        if(left > right) {
            return 0;
        }
        if(dp[left][right] != -1) return dp[left][right];
        int ans = 0;
        for(int i=left; i<=right; i++){
            int temp = nums[i]*(left-1<0?1:nums[left-1])*(right+1>=nums.length?1:nums[right+1]);
            ans = Math.max(ans,  temp + coins(nums, left, i-1, dp) + coins(nums, i+1, right, dp));
        }
         dp[left][right] = ans;
         return ans;
     }
}
// @lc code=end


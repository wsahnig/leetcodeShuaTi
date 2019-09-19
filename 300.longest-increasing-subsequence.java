/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        int max = 1;
        for(int i=0;i<len;i++){
            int tmp = 1;
            for(int j=0;j<i;j++){
               if(nums[i] > nums[j] && dp[j] + 1 > tmp){
                   tmp = dp[j] + 1;
               }
            }
            dp[i] = tmp;
            if(tmp > max) max = tmp;
        }
        return max;
    }
}


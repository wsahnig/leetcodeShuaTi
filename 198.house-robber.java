/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */
class Solution {
    
    public int rob(int[] nums) {
        int rob = 0;
        int notrob = 0;
        for(int i=0; i<nums.length;i++){
            int currob = notrob + nums[i];
            notrob = Math.max(notrob,rob);
            rob = currob;
        }
        return Math.max(rob,notrob);
    }
}


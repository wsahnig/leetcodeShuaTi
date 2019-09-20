/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */
class Solution {
    
        public int rob(int[] nums) {
            if(nums.length == 1) return nums[0];
            return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));  
        }
        private int rob(int[] nums,int lo,int hi) {
            int rob = 0;
            int notrob = 0;
            for(int i=lo; i<=hi;i++){
                int currob = notrob + nums[i];
                notrob = Math.max(notrob,rob);
                rob = currob;
            }
            return Math.max(rob,notrob);
        }
    
}


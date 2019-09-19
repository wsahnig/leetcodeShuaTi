/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */
class Solution {
    public int findDuplicate(int[] nums) {

        for(int i=0;i<nums.length;i++){
            int j = Math.abs(nums[i]);
            nums[j] *= -1;
            if(nums[j] > 0) return j;
        }
        return 0;
    }
}


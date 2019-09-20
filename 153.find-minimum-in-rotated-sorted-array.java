/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */
class Solution {
    public int findMin(int[] nums) {
       if(nums == null || nums.length == 0) return 0;
       for(int i=1; i < nums.length; i++){
            if(nums[i] < nums[i-1]) return nums[i];
       }
       return nums[0];
    }
}


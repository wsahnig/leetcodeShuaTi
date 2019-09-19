/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       
        for(int i=0;i<nums.length-1;i++){
           for(int j=1;j<=k && j < nums.length - i;j++){
               if(Math.abs((long)nums[i] - (long)nums[i+j]) <= t) return true;
           }
       }
       return false; 
    }
}


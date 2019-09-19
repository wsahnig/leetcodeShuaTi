/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1,p=0;
        int len = nums.length;
        for(int i=1;i<nums.length;i++){
           if(nums[i] == nums[i-1]){
               count++;
               if(count <= 2){
                   nums[++p] = nums[i];
               }
               else len--;
           }
           else{
               count = 1;
               nums[++p] = nums[i];
           }
        }
        return len;
    }
}


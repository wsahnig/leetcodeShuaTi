/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (59.52%)
 * Total Accepted:    444.2K
 * Total Submissions: 744.5K
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,1]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        int ans = nums[0];
        for(int i=0;i<nums.length;i=i+2){
            if(i== nums.length-1 || nums[i] != nums[i+1]){
                ans = nums[i];
                break;
            }               
        }
        return ans;
    }
}


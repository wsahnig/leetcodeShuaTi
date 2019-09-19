/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len+1) / 2;
        for(int i = 0;i<len;i++)
           sum -= nums[i];
        return sum;
    }
}


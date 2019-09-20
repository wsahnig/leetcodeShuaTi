/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= s){
                res = Math.min(res,right - left + 1);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}


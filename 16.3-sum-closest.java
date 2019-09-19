/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.11%)
 * Total Accepted:    294.9K
 * Total Submissions: 712.3K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len=nums.length,i=0,j=0,k=0,left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        Arrays.sort(nums);
        if(nums[len-3]+nums[len-2]+nums[len-1] <= target)
              return nums[len-3]+nums[len-2]+nums[len-1];
        else if(nums[0]+nums[1]+nums[2] >= target)
              return nums[0]+nums[1]+nums[2];

        for(i=0;i<len-2;i++)
           for(j=i+1;j<len-1;j++)
              for(k=i+2;k<len;k++){
                  if(nums[i]+nums[j]+nums[k] == target) return target;
                  else if(nums[i]+nums[j]+nums[k] > target){
                    right = right < nums[i]+nums[j]+nums[k] - target ? right : nums[i]+nums[j]+nums[k] - target;
                  }
                  else{
                      left = left < target - (nums[i]+nums[j]+nums[k]) ? left : target - (nums[i]+nums[j]+nums[k]);
                  }
              }
        return left < right ? target-left : target+right;
    }
}


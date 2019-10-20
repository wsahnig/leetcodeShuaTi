/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (29.84%)
 * Total Accepted:    215.8K
 * Total Submissions: 723.2K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<nums.length-3;i++){
            if(i == 0 || i>0 && nums[i] != nums[i-1]){
               for(int j=i+1;j<nums.length-2;j++){
                  if(j == i+1 || j > i+1 && nums[j] != nums[j-1]){
                      long sum = target-(nums[i] + nums[j]);
                      int lo = j+1 , hi = nums.length-1;
                      while(lo < hi){
                          long sum2 = nums[lo] + nums[hi];
                          if(sum == sum2){
                            ans.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                            lo++;
                            hi--;
                            while(lo < hi && nums[lo] == nums[lo-1]) lo++;
                            while(lo < hi && nums[hi] == nums[hi+1]) hi--;
                          }
                          else if(sum < sum2) hi--;
                          else lo++;
                      }
                  }
               }
            }

        }
        return ans;
    }
}


/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        int numViolations = 0;
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i - 1] > nums[i]) {
                
                if (numViolations == 1) {
                    return false;
                }
                
                numViolations++;
                
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}
// @lc code=end


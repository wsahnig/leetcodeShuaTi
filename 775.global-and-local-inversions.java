/*
 * @lc app=leetcode id=775 lang=java
 *
 * [775] Global and Local Inversions
 */

// @lc code=start
class Solution {
    public boolean isIdealPermutation2(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(Math.abs(nums[i]-i)>1) return false;
        }
        return true;
    }
    public boolean isIdealPermutation(int[] A) {
        int len = A.length;
        int mn = Integer.MAX_VALUE;
        for(int i=len-1; i>=2; i--)
        {
            mn = Math.min(mn, A[i]);
            if(A[i-2] > mn) return false;
        }
        return true;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.07%)
 * Total Accepted:    275.1K
 * Total Submissions: 831.3K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    private int extremeInsertionIndex(int[] nums,int target,boolean left){
        int lo = 0;
        int hi = nums.length;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1,-1};
        
        int leftIdx = extremeInsertionIndex(nums, target, true);

        if(leftIdx == nums.length || nums[leftIdx] != target){
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums,target,false) -1;

        return targetRange;
    }
}


/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.69%)
 * Total Accepted:    379.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        if(hi < 0) return -1;
        while(lo < hi){
            int mid = (lo+hi) / 2;
            if(nums[mid] == target) return mid;
            //找有序段
            if(nums[lo] <= nums[mid]){
                if(target >= nums[lo] && target < nums[mid]){
                    hi = mid - 1;
                }
                else{
                    lo = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[hi]){
                    lo = mid + 1;
                } else{
                    hi = mid - 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }
}


/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0 , hi = nums.length - 1;
        while(lo < hi){
            if(hi == lo + 1)
               return nums[lo] > nums[hi] ? lo : hi;
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[mid - 1]
            && nums[mid] > nums[mid + 1]) return mid;
            else if(nums[mid] < nums[mid-1] &&
            nums[mid+1] < nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}


/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (35.04%)
 * Total Accepted:    338.4K
 * Total Submissions: 965.5K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        for(i=m; i < m+n; i++){
            nums1[i] = nums2[j++];
        }
        for(i=m; i< m+n ; i++){
            int tmp = nums1[i];
            for(j=i-1 ; j>=0 && nums1[j] > tmp;j--){
                 nums1[j+1] = nums1[j];
            }
            nums1[j+1] = tmp;
        }

    }
}


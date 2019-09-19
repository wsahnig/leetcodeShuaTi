/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.62%)
 * Total Accepted:    390.5K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length,l2 = nums2.length,index = (l1 + l2) / 2,i=0,j=0,k=0;
        int tmp1 = 0,tmp2 = 0;
        double ans = 0.0;
        while(k <= index){
            if(i != l1 && (j == l2 || nums1[i] <= nums2[j]) ){

                tmp1 = nums1[i];
                i++;
                
            }
            else if(j != l2  &&  (i == l1 || nums1[i] > nums2[j]) ){

                tmp1 = nums2[j];
                j++;                
                
            }
            if( (l1 + l2) % 2 == 0 && k == index - 1){
                  tmp2 = tmp1;

            }

            else if( (l1 + l2) % 2 == 0 && k == index){
                ans = (tmp1 + tmp2) / 2.0 ;
            }

            else if((l1 + l2) % 2 != 0 && k == index){
                ans = tmp1;
            }

            k++;
        }
        return ans;

    }
}


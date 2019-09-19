/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.10%)
 * Total Accepted:    218.7K
 * Total Submissions: 726.6K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums,int i){
        int len = nums.length - i;
        for(int j=i ; j < i + len/2 ;j++){
            swap(nums,j,nums.length - j - 1 + i);
        }
    }
    
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0){
            if( nums[i] < nums[i+1] )
                break;
            else i--;
        }
        int j = nums.length - 1;
        if(i >= 0){
            while(j >= 0){
                if(nums[j] > nums[i]) break;
                else j--;
            }
            swap(nums,i,j);
        }
        
        reverse(nums,i+1);

    }
}


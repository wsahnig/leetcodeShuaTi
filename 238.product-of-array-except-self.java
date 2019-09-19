/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] result = new int[nums.length];
       int tmp = 1;
       //第一次循环，result[i]等于i位置数之前所有数的乘积
       for(int i=0;i<nums.length;i++){
           result[i] = tmp;
           tmp *= nums[i];
       }
      //第二次反向循环，result[i]乘以i位置数之后所有数的乘积
      tmp=1;
      for(int i= nums.length-1;i>=0;i--){
          result[i] *= tmp;
          tmp *= nums[i];
      }
      return result;
    }
}


/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int tmp = nums[0];
        for(int i=1; i<nums.length; i++){
            tmp ^= nums[i];
        }
        int lob = Integer.lowestOneBit(tmp);
        int num1 = 0;
        int num2 = 0;
        for(int num : nums){
            if((num & lob) != 0){
                num1 ^= num;
            }
            else{
                num2 ^= num;
            }
        }
        res[0] = num1;
        res[1] = num2;
        return res;
    }
}


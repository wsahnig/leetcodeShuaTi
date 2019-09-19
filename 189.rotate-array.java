/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return;
        k = k % len;
        for(int i=0;i<k;i++){
            int tmp = nums[len-1];
            for(int j=len-2;j>=0;j--){
                nums[j+1] = nums[j];
            }
            nums[0]=tmp;
        }
    }
}


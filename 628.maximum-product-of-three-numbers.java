/*
 * @lc app=leetcode id=628 lang=java
 *
 * [628] Maximum Product of Three Numbers
 */
class Solution {
    public int maximumProduct(int[] nums) {
        if(nums == null) return 0;
        //Arrays.sort(nums);
        int len = nums.length;
        if(len < 3) return 0;
        int max=-1001,max2=-1001,max3=-1001;
        int min=1001,min2=1001;
        for(int i=0;i<len;i++){
             if(nums[i] > max){
                 max3 = max2;
                 max2 = max;
                 max = nums[i];
                 
             }else if(nums[i] > max2){
                 max3 = max2;
                 max2 = nums[i];
             }else if(nums[i] > max3){
                 max3 = nums[i];
             }

             if(nums[i] < min){
                 min2 = min;
                 min = nums[i];
             }else if(nums[i] < min2){
                 min2 = nums[i];
             }
        }
        return max * Math.max(max2*max3,min*min2);

        // return nums[len-1]*Math.max(nums[len-2]*nums[len-3]
        // ,nums[0]*nums[1]);
    }
}


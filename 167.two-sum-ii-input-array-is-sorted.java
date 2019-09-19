/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        int sum = numbers[i] + numbers[j];
        while(sum != target){   
            if(sum < target) i++;
            else  j--;
            sum = numbers[i] + numbers[j];
        }
        return new int[]{i+1,j+1};
    }
}


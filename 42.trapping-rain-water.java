/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
       // write code here
       int res = 0;
       if(height == null || height.length <= 2) return res;
       int left = 0, right = height.length-1;
       //min is the smaller one between the leftest and the rightest
       int min = Math.min(height[left], height[right]);
       while(left < right)
       {
           if(height[left] < height[right])
           {
               left++;
               if(min <= height[left])
               {
                   min = Math.min(height[left], height[right]);
               }
               else
               {
                   res +=  min-height[left];
               }
           }
           else
           {
               right--;
               if(min <= height[right])
               {
                   min = Math.min(height[left], height[right]);
               }
               else
               {
                   res += min-height[right];
               }
           }
       }
       return res; 
    }
}
// @lc code=end


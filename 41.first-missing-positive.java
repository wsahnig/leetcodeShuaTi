/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        int i = 0;
        while(i < len)
        {
            if(nums[i] < 0 || nums[i] >= len || nums[i] == i || nums[i] == nums[nums[i]]) i++;
            else
            {
                if(nums[i] >= 0 && nums[i] < len)
                {
                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
        }
        
        for(i=1; i<=len; i++)
        {
            if(nums[i%len] != i) return i;
        }
        return i;
    }
}
// @lc code=end


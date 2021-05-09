/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump2(int[] nums) {
        int len = nums.length;
        int[] steps = new int[len];
        for(int i=0; i<len; i++)
        {
           for(int j=1;j<=nums[i];j++)
           {
               if(i+j < len)
               {
                    steps[i+j] = steps[i+j] == 0 ? steps[i]+1 :
                    Math.min(steps[i+j], steps[i]+1);
               }
           }
        }
        return steps[len-1]; 
    }
    public int jump(int[] nums)
    {
        int len = nums.length;
        int step = 0;
        int cnt = 0;
        while(step < len-1)
        {
            cnt++;
            int curMaxStep = nums[step];
            int max = 0;
            int index = step;
            if(step + curMaxStep >= len-1) return cnt;
            for(int i=1; i<=curMaxStep; i++)
            {
                if(nums[i+step]+i > max)
                {
                    max = nums[i+step]+i;
                    index = i+step;
                }   
            }
            step = index;
        }
        return cnt;
    }
}
// @lc code=end


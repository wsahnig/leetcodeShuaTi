/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] cnt = new int[target+1];
        cnt[0]=1;
        for(int i=1; i<=target; i++)
        {
            for(int j=0; j<len; j++)
            {
                if(nums[j]>i) break;
                cnt[i] += cnt[i-nums[j]];
            }
        }
        return cnt[target];
    }
}
// @lc code=end


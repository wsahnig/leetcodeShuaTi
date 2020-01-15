import java.util.Map;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        //hm的key表示连续数组和，value表示连续和出现的次数
        Map<Integer,Integer> hm = new HashMap();
        hm.put(0,1);
        for(int i=0;i<nums.length;i++){
             sum += nums[i];
             
             if(hm.containsKey(sum-k)){
                 count += hm.get(sum-k);
             }

             hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
// @lc code=end


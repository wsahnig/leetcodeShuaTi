/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length,maxIdx=0;
        List<Integer>[] dp = new ArrayList[len];
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            dp[i] = new ArrayList();
        }
        if(len == 0) return new ArrayList();
        dp[0].add(nums[0]);
        for(int i=1;i<len;i++){
            int tmp = i;
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0 && dp[tmp].size() < dp[j].size()){
                    tmp = j;
                }
            }
            dp[i].addAll(dp[tmp]);
            dp[i].add(nums[i]);
            if(dp[i].size() > dp[maxIdx].size()){
                maxIdx = i;
            }
        }
        return dp[maxIdx];
    }
}


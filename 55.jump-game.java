/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.59%)
 * Total Accepted:    252K
 * Total Submissions: 796.3K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
enum Index {
    GOOD, BAD, UNKNOWN
}
class Solution {
    Index[] memo;

    public boolean judge(int pos,int[] nums){
        if(memo[pos] != Index.UNKNOWN){
            return memo[pos] == Index.GOOD ? true : false;
        }
        int furthestJump = Math.min(pos + nums[pos],nums.length-1);
        for(int i=furthestJump;i > pos;i--){
              if(judge(i,nums)){
                  memo[pos] = Index.GOOD;
                  return true;
              }
        }
        memo[pos] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return judge(0,nums);
    }
}


/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // convert problem to two-sum
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        // store all the possible sums and their frequency in the map
        for(int a : A) {
            for(int b : B) {
			    int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // find the ones that equals to -sum in previous map, thus they add up to zero
        // and return their frequecy
        for(int c : C) {
            for(int d : D) {
                res += map.getOrDefault(-1 * (c + d), 0);
            }
        }
        return res;
    }
}
// @lc code=end


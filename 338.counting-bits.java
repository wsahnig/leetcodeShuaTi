/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */
class Solution {
    public int[] countBits(int num) {
        int[] cnt = new int[num+1];
        for(int i=1;i<=num;i++){
            cnt[i] = cnt[i >> 1] + (i & 1);
        }
        return cnt;
    }
}


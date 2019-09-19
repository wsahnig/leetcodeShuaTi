/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i=0;i<32;i++){
            if((n & 1)==1)cnt++;
            n = n >> 1;
        }
        return cnt;
    }
}


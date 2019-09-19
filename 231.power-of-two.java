/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        
        while(n != 1){
            if((n & 1) != 0) return false;
            n = n >> 1;
        }

        return true;
    }
}


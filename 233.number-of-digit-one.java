/*
 * @lc app=leetcode id=233 lang=java
 *
 * [233] Number of Digit One
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        // int count = 0;
        // for(long i=1;i<=n;i*=10){
        //     long divider = i*10;
        //     count += (n/divider) * i + Math.min(Math.max(n%divider-i+1,0),i);
             
        // }
        // return count;
        return countNumberOfKs(n,1);
    }
    private int countNumberOfKs(int n,int k) {
        // write code here
        int res = 0;
        for (long m = 1;m <= n;m *= 10) {
            long tmp1 = n / m, tmp2 = n%m;
            res += (tmp1 + 10-k-1) / 10 * m + (tmp1 % 10 == k ? 1:0)*(tmp2 + 1);
        }
        return res;
    }

}
// @lc code=end


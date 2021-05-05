/*
 * @lc app=leetcode id=1551 lang=java
 *
 * [1551] Minimum Operations to Make Array Equal
 */

// @lc code=start
class Solution {
    public int minOperations2(int n) {
        int target = n;
        int sum = 0;
       for(int i=0;i<n/2;i++)
       {
            sum += target - (2*i+1);
       }
       return sum; 
    }
    public int minOperations(int n)     {
        if( (n & 1) == 0){
            n /= 2;
            return n*n;
        }
        else{
            n++;
            n/=2;
            return n*(n-1);
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        
        int lo = 1,hi = num;
        while(lo <= hi){
            int mid = lo +(hi - lo)/2;
            long tmp = mid * mid;
            if(num == tmp) return true;
            else if(num / mid < mid) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}


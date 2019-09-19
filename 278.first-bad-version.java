/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while(hi > lo){
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)){
                hi = mid; 
            }
            else{
               lo = mid+1;
            }
        }  
        return lo;
    }
}


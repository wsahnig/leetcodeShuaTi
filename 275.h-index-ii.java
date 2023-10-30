/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */
class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;
        //最小的索引left使得len - left >= citations[i]
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = citations.length - mid;
            if(cnt <= citations[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return citations.length - left;
    }
}


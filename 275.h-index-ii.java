/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int cnt1 = 0,cnt2 = 0;
        int tar = len;
        int i = len-1;
        while(i>=0){
            while(i>=0 && citations[i] >= tar){
                if(citations[i] > tar) cnt1++;
                cnt2++;
                i--;
            }           
            if(cnt1 <= tar && cnt2 >= tar) return tar;
            tar--;
            cnt1 = cnt2;
        }
        return 0;
    }
}


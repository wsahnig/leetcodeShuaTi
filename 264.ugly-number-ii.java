/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNum = new int[n];
        int m2 = 0,m3 = 0,m5 = 0;
        uglyNum[0] = 1;
        for(int i=1;i<n;i++){
            int min = Math.min(uglyNum[m2] * 2, Math.min(uglyNum[m3]*3,
            uglyNum[m5]*5));
            uglyNum[i] = min;
            //下面三个条件不是互斥的，可能有重合
            //比如m2=2 时, m3=1 ,uglyNum[1] * 3 = uglyNum[2] * 2 = 6
            if(min == uglyNum[m2] * 2) m2++;
            if(min == uglyNum[m3] * 3) m3++;
            if(min == uglyNum[m5] * 5) m5++;
        }
        return uglyNum[n-1];
    }
}


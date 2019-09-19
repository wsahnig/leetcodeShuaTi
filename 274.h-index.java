/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] moreThan = new int[len+1];
        int[] notLessThan = new int[len+1];
        for(int i=0;i<len;i++){
            if(citations[i] > len){
                moreThan[len]++;
                notLessThan[len]++;
            }
            else if(citations[i] > 0){
                moreThan[citations[i]-1]++;
                notLessThan[citations[i]]++;
            }
        }
        for(int i=len-1;i>=0;i--){
            moreThan[i] += moreThan[i+1];
            notLessThan[i] += notLessThan[i+1];
        }
        for(int h=len;h>=0;h--){
            if(moreThan[h] <= h && notLessThan[h] >= h)
            return h;
        }
        return 0;
    }
}


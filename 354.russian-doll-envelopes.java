/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0) return 0;
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }    
        });
        int[] end = new int[envelopes.length];
        end[0] = envelopes[0][1];
        int l=0,r=0,m=0;
        int right=0;
        for(int i=1;i<envelopes.length;i++){
            l=0;
            r=right;
            
            while(l <= r){
                m=(l+r)/2;
                if(envelopes[i][1] <= end[m]){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
            right = Math.max(right,l);
            end[l] = envelopes[i][1];
        }
        return right+1;
    }
}


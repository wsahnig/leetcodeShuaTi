/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */
class Solution {


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = -1;
        int i=0,j=0,k=0;
        int curr = 0;
        for(i=0;i<gas.length;i++){
            curr+=gas[i];
            k=i;
            j=(i + 1) % gas.length;
            while(j != i){
                if(curr < cost[k]) break;               
                curr = curr - cost[k] + gas[j];
                k = j;
                j = (k + 1) % gas.length;
            }
            if(j == i && curr >= cost[k]){
                
                ans = i;
                break;
                
            }
            curr = 0;
        }
        return ans;
    }
}


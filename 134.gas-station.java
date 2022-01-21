/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //逆向找 最大的sum和(为了走得尽可能远，以免车站左边无法抵达) 
        //如果它都不能走完全程回到原点，那么这样的点就不存在。
        int start = -1;
        int sum = 0;
        int max = -1;
        for(int i = gas.length-1; i >= 0; i--)
        {
            int remain = (gas[i] - cost[i]);
            sum += remain;
            
            if(sum > max)
            {
                start = i;
                max = sum;
            }
            
        }
        return sum >= 0 ? start : -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
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


/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] uglyNum = new int[n];
        int[] weight = new int[primes.length];
        uglyNum[0] = 1;
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                 int tmp = primes[j] * uglyNum[weight[j]];
                 if(tmp < min){
                     min = tmp;
                 } 
            }
            uglyNum[i] = min;
            for(int j=0;j<primes.length;j++){
                if(primes[j] * uglyNum[weight[j]] == min){
                    weight[j]++;
                }
            } 
        }
        return uglyNum[n-1];
    }
}


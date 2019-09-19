/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */
class Solution {
    private boolean judgePrime(int n){
        for(int x=2; x<=(int)Math.sqrt(n); x++){
            if(n % x == 0) return false;
        } 
        return true;
    }
    public int countPrimes(int n) {
        int cnt = 0;
        for(int i=2;i<n;i++){
            if(judgePrime(i)) cnt++;
        }
        return cnt;
    }
}


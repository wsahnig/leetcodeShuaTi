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
    public int countPrimes2(int n) {
        int cnt = 0;
        for(int i=2;i<n;i++){
            if(judgePrime(i)) cnt++;
        }
        return cnt;
    }
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
           isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
           if (!isPrime[i]) continue;
           for (int j = i * i; j < n; j += i) {
              isPrime[j] = false;
           }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
           if (isPrime[i]) count++;
        }
        return count;
     }
}


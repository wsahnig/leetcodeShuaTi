/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */
class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while(true){
            sum += num % 10;
            num /= 10;
            if(num == 0 && sum > 9){num = sum; sum=0;}
            if(num == 0 && sum < 10) return sum;
        }
    }
}


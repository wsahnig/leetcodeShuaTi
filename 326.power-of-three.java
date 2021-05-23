/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */
class Solution {
    public boolean isPowerOfThree2(int n) {
        double a = Math.log(n) / Math.log(3);
        //double rint(double x)  最接近参数的整数值
        return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
    }
    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }
}


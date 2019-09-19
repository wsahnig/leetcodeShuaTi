/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        double a = Math.log(n) / Math.log(3);
        //double rint(double x)  最接近参数的整数值
        return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
    }
}


/*
 * @lc app=leetcode id=365 lang=java
 *
 * [365] Water and Jug Problem
 */
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z==x+y || z==x || z==y || z==0){
            return true;
        }
        if(x==0 || y==0 || z > x+y || z % gcd(x,y) != 0){
            return false;
        }
        return true;
    }
    int gcd(int a,int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}


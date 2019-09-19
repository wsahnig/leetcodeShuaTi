import java.util.HashSet;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(n);
        while(n != 1){
            int result = 0;
            while(n != 0){
                result += Math.pow(n % 10, 2);
                n /= 10;
            }
            if(hs.contains(result)){
                return false;
            }
            hs.add(result);
            n = result;
        }
        return true;
    }
}


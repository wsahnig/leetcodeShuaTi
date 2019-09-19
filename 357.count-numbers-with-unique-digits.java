/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 */
class Solution {
    public static int helper(long curr,long max,boolean[] used){
        int count = 0;
           
            if(curr < max){
                count++;
            }else{
                return count;
            }
        
        for(int i=0;i<=9;i++){
            if(curr==0 && i==0) continue;
            if(!used[i]){
                used[i] = true;
                count += helper(curr*10+i,max,used);
                used[i] = false;
            }
        }
        return count;
    }

    public int countNumbersWithUniqueDigits(int n) {
        if(n > 10) return countNumbersWithUniqueDigits(10);
        long max = (long) Math.pow(10,n);
        boolean[] used = new boolean[10];
        return helper(0,max,used);
    }
}


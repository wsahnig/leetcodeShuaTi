import java.math.*;
import java.util.*;
/*
 * @lc app=leetcode id=306 lang=java
 *
 * [306] Additive Number
 */
class Solution {
    
    private boolean helper(List<BigDecimal> list,int start,String num){
        if(list.size() > 2){
            int len = list.size();
            BigDecimal x = list.get(len-2);
            BigDecimal y = list.get(len-3);   
            if(list.get(len-1).compareTo(x.add(y)) != 0 ) {
                return false;
            }
            if(start == num.length()) {
                return true; 
            }
        }

        for(int k=start+1;k<=num.length();k++){
            if(num.charAt(start) == '0' && k == start+1 || num.charAt(start) != '0') {
                String sub = num.substring(start,k);
                list.add(new BigDecimal(sub));
                if(helper(list,k,num)) return true;
                list.remove(list.size()-1);
            }
        }

        return false;
    }
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3) return false;
        return helper(new ArrayList(),0,num); 
    }
}

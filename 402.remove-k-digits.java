
/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */
import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len==0) return "0";
        Stack<Character> st = new Stack();
        for(char c : num.toCharArray()){
            while(k > 0 && !st.isEmpty() && c < st.peek()){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k-- > 0){
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        //去掉前导0
        while(sb.length()>1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}


/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */
class Solution {
    public String reverseWords(String s) {
        if("".equals(s) || " ".equals(s)) return "";
        String[] str = s.trim().split(" ");
        StringBuilder sb  = new StringBuilder();
        for(int i=str.length-1;i>0;i--){
            if(str[i].length() <= 0) continue;
            sb.append(str[i]+" ");
        }
        sb.append(str[0]);
        return sb.toString();
    }
}


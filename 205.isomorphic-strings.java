/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] match = new int[512];
        for(int i=0;i<s.length();i++){
            if(match[s.charAt(i)] != match[t.charAt(i)+256]) return false;
            match[s.charAt(i)] = match[t.charAt(i)+256] = i+1;
        }
        return true;
    }
}


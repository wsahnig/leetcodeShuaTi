/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */
class Solution {
    private String sortString(String s){
        char[] x = s.toCharArray();
        Arrays.sort(x);
        return String.valueOf(x);
    }
    public boolean isAnagram(String s, String t) {
        s = sortString(s);
        t = sortString(t);
        return s.equals(t);
    }
}


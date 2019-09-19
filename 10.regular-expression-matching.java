/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {
    public boolean isMatch(String s,int i,String p,int j){
        if(i == s.length() && j == p.length()){
            return true;
        }
        if(i != s.length() && j == p.length()){
            return false;
        }
        if(i == s.length() && j != p.length()){
            while(p.length()-j >= 2 && p.charAt(j+1) == '*'){
                j+=2;
            }
            if(j == p.length()) {
                return true;
            }
            else{
                return false;
            }
        }
        
        
        //1
        if(j < p.length()-1 && p.charAt(j+1) == '*'){
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                return isMatch(s, i+1, p, j+2) || //匹配1次
                   isMatch(s,i+1,p,j) || //匹配多次
                   isMatch(s,i, p,j+2); //这一项相同但匹配0次
            }else{
                return isMatch(s,i, p,j+2);
            }
        }
        //2
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            return isMatch(s, i+1,p ,j+1);
        }
        
        //3 前面的都不满足，匹配失败
        return false;

    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
}


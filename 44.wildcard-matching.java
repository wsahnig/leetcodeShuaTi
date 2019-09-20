/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */
class Solution {
    // public boolean isMatch(String s,int i,String p,int j){
    //     if(i == s.length() && j == p.length()){
    //         return true;
    //     }
    //     if(i != s.length() && j == p.length()){
    //         return false;
    //     }
    //     if(i == s.length() && j != p.length()){
    //         if(j == p.length()-1 && p.charAt(j) == '*') {
    //             return true;
    //         }
    //         else{
    //             return false;
    //         }
    //     }
        
        
    //     //1
        
    //     if(p.charAt(j) == '*'){
    //         return 
    //             isMatch(s,i+1,p,j) || //匹配多次
    //             isMatch(s,i, p,j+1); //这一项相同但匹配空串
    //     }
        
    //     //2
    //     else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
    //         return isMatch(s, i+1,p ,j+1);
    //     }
        
    //     //3 前面的都不满足，匹配失败
    //     return false;

    // }

    // public boolean isMatch(String s, String p) {
    //     //p中连续的*变为一个*
    //     StringBuilder sb = new StringBuilder();
    //     for(int i=0;i<p.length();i++){
    //         if(p.charAt(i) == '*' && i>0 && p.charAt(i-1)=='*'){
    //             continue;
    //         }
    //         sb.append(p.charAt(i));
    //     }

    //     return isMatch(s, 0, sb.toString(), 0);
    // }
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()] = true;
        int i = p.length()-1;
        while(i>=0 && p.charAt(i) == '*'){
            match[s.length()][i--] = true;
        }
        int j;
        for(i=s.length()-1;i>=0;i--){
            for(j=p.length()-1;j>=0;j--){
                 if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                      match[i][j] = match[i+1][j+1];
                 }
                 else if(p.charAt(j) == '*'){
                      match[i][j] = match[i][j+1] || match[i+1][j];
                 }
                 else{
                     match[i][j] = false;
                 }
            }
        }
        return match[0][0];

    }
}


/*
 * @lc app=leetcode id=838 lang=java
 *
 * [838] Push Dominoes
 */

// @lc code=start
class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        if(dominoes == null || dominoes.length()==0) return sb.toString();
        int len = dominoes.length();
        char c;
        for(int i=0;i<len;i++){
            c = dominoes.charAt(i);
            if(c == '.') cnt++;
            else if(c == 'L'){
                while(cnt-- >= 0){
                    sb.append('L');
                }
                cnt=0;
            }
            while(c == 'R' && i < len){
                while(cnt-- != 0){
                    sb.append('.');
                }
                cnt=0;
                while(++i<len && (c=dominoes.charAt(i)) == '.'){
                    cnt++;
                }
                if(i==len || c == 'R'){
                    while(cnt-- >= 0){
                        sb.append('R');
                    }    
                }else{
                    for(int k=0;k<=cnt/2;k++) sb.append('R');
                    if(cnt % 2 != 0) sb.append('.');
                    for(int k=0;k<=cnt/2;k++) sb.append('L');
                }
                cnt=0;
            }
        }

        for(int k=0;k<cnt;k++) sb.append('.');
        return sb.toString();
    }
}
// @lc code=end


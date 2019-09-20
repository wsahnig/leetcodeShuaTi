/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
class Solution {
    class Match{
        boolean hasMatched;
        int currLen;
        public Match(){
            this.hasMatched = false;
            this.currLen = 0;
        }
    }

    public int longestValidParentheses(String s) {
        if(s == null || s.length()==0) return 0;
        int len = s.length();
        Match[] match = new Match[len];
        
        int longestlen = 0;
        //遍历字符串
        for(int i=0;i<len;i++){
             match[i] = new Match();
             if(s.charAt(i) == '('){
                 //如果是左括号，且前一个是右括号，则更新长度
                 if(i > 0 && s.charAt(i-1) == ')')
                 match[i].currLen = match[i-1].currLen;
             }else{
               //如果是右括号，反向找到第一个未匹配的左括号，当前匹配长度改变，结束；
               //如果反向先出现未匹配的右括号，匹配长度为0，结束；
               //如果j小于0,结束
               for(int j=i-1;j>=0;j--){
                   if(s.charAt(j) == ')' && !match[j].hasMatched){
                       break;
                   }
                   else if(s.charAt(j) == '(' && !match[j].hasMatched){
                      match[j].hasMatched = true;
                      match[i].hasMatched = true;
                      
                      match[i].currLen = match[i-1].currLen+2;
                      //如果左括号不是前一个元素
                      if(i-1 != j){
                          match[i].currLen += match[j].currLen;
                      }
                      //结束
                      break;
                   }
               }
               if(match[i].currLen > longestlen){
                   longestlen = match[i].currLen;
               }
             }
             //System.out.print(match[i].currLen+" ");
        }
        return longestlen;
    }
}


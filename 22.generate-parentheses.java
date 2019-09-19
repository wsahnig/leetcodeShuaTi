/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (53.49%)
 * Total Accepted:    308.6K
 * Total Submissions: 577K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {

   List<String> ans = new ArrayList<String>();

   void backtrack(String curr,int open,int close,int max){
       if(close == max){
           ans.add(curr);
       }

       if(open < max){
           backtrack( curr+"(" ,open+1 ,close,max);
       }
       if(close < open){
           backtrack( curr+")" ,open ,close+1 ,max);
       }
   }

    public List<String> generateParenthesis(int n) {
        
        backtrack("",0,0,n);

        return ans;
    }
}


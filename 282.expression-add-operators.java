/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(res,sb,num,0,target,0,0);
        return res;
    }
    private void dfs(List<String> res,StringBuilder sb,String num,int start,int target,long prev,long multi){
        if(start == num.length()){
            if(target == prev){
                res.add(sb.toString());
            }
            return;
        }
        for(int i=start;i < num.length(); i++)
        {
            if( num.charAt(start) == '0' && i != start){ // 
                break;
            }
            
            long curr = Long.parseLong(num.substring(start,i+1));
            int len = sb.length();
            if(start == 0){
                dfs(res,sb.append(curr),num,i+1,target,curr,curr);
                sb.setLength(len);
            }
            else{
                dfs(res,sb.append("+").append(curr), num, i+1, target, prev+curr, curr);
                sb.setLength(len);
                
                dfs(res,sb.append("-").append(curr), num, i+1, target, prev-curr, -curr);
                sb.setLength(len);
                
                dfs(res,sb.append("*").append(curr), num, i+1, target, prev-multi+multi*curr, multi*curr);
                sb.setLength(len);
            }
        }
    }
}
// @lc code=end


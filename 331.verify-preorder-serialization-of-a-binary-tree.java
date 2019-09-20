/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */
class Solution {
    //字符串转成字符串数组，坑
    public boolean isValidSerialization(String preorder) {
        if(preorder == null) return false;
        
        Stack<String> st = new Stack();
        
        String[] arr =  preorder.split(",");
         
        //两个#就是这个题的关键
        for(String c : arr){
            
            if(!"#".equals(c) || !st.isEmpty() && !st.peek().equals("#")){
                st.push(c);
            }
            else{
                while(st.size()>1 && st.peek().equals("#")){
                    //出栈#
                    st.pop();
                    //出栈节点
                    if(st.peek().equals("#")) return false;
                    st.pop();        
                }
                //将节点标记为#
                st.push("#");
            }    
        }
        //System.out.println(st.size());
        return st.size() == 1 && st.peek().equals("#");
    }
}


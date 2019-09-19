/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack();
        for(Character ch : s.toCharArray()){
            if(ch != ']'){
                st.push(ch);
            }
            else{// when ]
                //repeated str
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && Character.isLetter(st.peek())){
                    sb.insert(0,st.pop());
                }
                String str = sb.toString();
                //skip [
                st.pop();
                // repeated cnt
                sb = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                   sb.insert(0,st.pop());
                }
                int cnt = Integer.parseInt(sb.toString());
                //decode and push stack
                while(cnt-- > 0){
                    for(char c : str.toCharArray() ){
                        st.push(c);
                    }
                }    
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
             res.insert(0,st.pop());
        }
        return res.toString();
    }
}


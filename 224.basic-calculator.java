/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */
class Solution {
    public int calculate2(String s) {
        
        Stack<Integer> st = new Stack();
        //sign表示之前的运算符
        char sign = '+';
        String operator = "+-*/";
        int num = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(operator.indexOf(c) != -1 ||  i == s.length()-1){
                if(sign == '+'){
                    st.push(num);
                }else if(sign == '-'){
                    st.push(-num);
                }else if(sign == '*'){
                    st.push(st.pop() * num);
                }else if(sign == '/'){
                    st.push(st.pop() / num);
                }
                sign = c;
                num = 0;
            }
            if(c == '('){
                int cnt = 1;
                int j = i;
                while(cnt != 0){
                    j++;
                    if(s.charAt(j) == '(') cnt++;
                    else if(s.charAt(j) == ')') cnt--;
                }
                String sub = s.substring(i+1,j);
                num = calculate(sub);
                i = j-1;
            }
        }
        int res = 0;
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }

    int i=0;
	public int calculate(String s) {
	    Stack<Integer> st = new Stack();
	    //sign表示之前的运算符
	    char sign = '+';
	    String operator = "+-*/";
	    int num = 0;
	    int len = s.length();
	    for(;i<len;i++){
	        char c = s.charAt(i);
	        if(Character.isDigit(c)){
	            num = num * 10 + c - '0';
	        }
	        if(operator.indexOf(c) != -1 ||  i == s.length()-1 ||  s.charAt(i+1) == ')'){
	            pushOperand(st, sign, num);
	            sign = c;
	            num = 0;
	        }
	        if(c == '('){
	            i=i+1;
	            num = calculate(s);
	            //下面的代码考虑的是，右括号作为结束的情况
	            pushOperand(st, sign, num);
	            sign = c;//只要不是运算符就不会重复
	            num = 0;
	        }
	        if(c == ')'){
	            return getResult(st);
	        }
	
	    }
	    return getResult(st);
	}
	
	private static int getResult(Stack<Integer> st) {
	    int res = 0;
	    while (!st.isEmpty()) {
	        res += st.pop();
	    }
	    return res;
	}
	
	private static void pushOperand(Stack<Integer> st, char sign, int num) {
	    if (sign == '+') {
	        st.push(num);
	    } else if (sign == '-') {
	        st.push(-num);
	    }else if(sign == '*'){
	        st.push(st.pop() * num);
	    }else if(sign == '/'){
	        st.push(st.pop() / num);
	    }
	}
}


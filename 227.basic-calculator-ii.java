import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */
//与第150题做对比
class Solution {
    private int calculator(int x,int y,char c){
        if(c=='+') return x+y;
        else if(c=='-') return x-y;
        else if(c=='*') return x*y;
        else return x/y;
    }

    public int calculate(String s) {
        if(s == null || s.length()==0) return 0;
        Stack<Integer> nums = new Stack();
        Stack<Character> ops = new Stack();

        Map<Character,Integer> operation = new HashMap();
        operation.put('+',1);
        operation.put('-',1);
        operation.put('*',2);
        operation.put('/',2);
        Set<Character> keys = operation.keySet();

        s = s.replaceAll(" +", "");
        if(s.length()==0) return 0;

        int num = 0,x=0,y=0;
        char c = 0;

        for(int i=0;i<s.length();i++){
            num = 0;
            while(i<s.length() && s.charAt(i)>='0' &&
            s.charAt(i) <= '9'){
                num *= 10;
                num += s.charAt(i)-'0';
                i++;
            }
            nums.push(num);
            if(i == s.length()) break;

            if(keys.contains(s.charAt(i))){
                if(ops.isEmpty() ||
                  operation.get(s.charAt(i)) > operation.get(ops.peek()) ){
                      ops.push(s.charAt(i));
                  }
                else{
                    while(!ops.isEmpty() && operation.get(s.charAt(i)) <= operation.get(ops.peek()) 
                    && nums.size()>1){
                        x = nums.pop();
                        y = nums.pop();
                        c = ops.pop();
                        nums.push(calculator(y,x,c));
                    }
                    ops.push(s.charAt(i));
                }
            }
        }
        while(nums.size()>1){
            x = nums.pop();
            y = nums.pop();
            c = ops.pop();
            nums.push(calculator(y,x,c)); 
        }
        return nums.peek();
    }
}


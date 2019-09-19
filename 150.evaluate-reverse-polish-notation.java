/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> nums = new Stack();
       for(int i=0; i<tokens.length; i++){
           if(tokens[i].charAt(0) >= '0' && 
           tokens[i].charAt(0) <= '9' || tokens[i].length() > 1){
               nums.push(Integer.parseInt(tokens[i]));
           }
           else{
               int num1 = nums.pop();
               int num2 = nums.pop();
               if("+".equals(tokens[i])){
                  nums.push(num2 + num1);
               }
               else if("-".equals(tokens[i])){
                  nums.push(num2 - num1);
               }
               else if("*".equals(tokens[i])){
                nums.push(num1 * num2); 
               }
               else if("/".equals(tokens[i])){
                nums.push(num2 / num1);
               }
               System.out.println(nums.size());                         
           }
       }
       return nums.peek();
    }
}


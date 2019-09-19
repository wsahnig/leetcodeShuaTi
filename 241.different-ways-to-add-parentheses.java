/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
       List<Integer> res = new ArrayList<Integer>();
       for(int i=0; i < input.length(); i++){
          if(input.charAt(i) == '-' ||
             input.charAt(i) == '*' ||
             input.charAt(i) == '+' ) {
               List<Integer> part1res = diffWaysToCompute(input.substring(0,i));
               List<Integer> part2res = diffWaysToCompute(input.substring(i+1));
               for(Integer i1 : part1res){
                   for(Integer i2 : part2res){
                       switch(input.charAt(i)) {
                           case '+' : res.add(i1 + i2);break;
                           case '-' : res.add(i1 - i2);break;
                           case '*' : res.add(i1 * i2);break;
                       }
                   }
               }
            } 
       }
       if(res.size() == 0){
           res.add(Integer.parseInt(input));
       }
       return res; 
    }
}


/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start
class Solution {
    class Pair {
        char c;
        int o;
        Pair(char val, int occ) {
            this.c = val;
            this.o = occ;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> stack = new Stack();
        
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().c == c) {
                stack.peek().o++;
            } else {
                stack.push(new Pair(c, 1));
            }
            
            if(stack.peek().o == k) {
                stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Pair p: stack) {
            for(int i = 0; i < p.o; i++) {
                sb.append(p.c);
            }
        }
        
        return sb.toString();
    }
}
// @lc code=end


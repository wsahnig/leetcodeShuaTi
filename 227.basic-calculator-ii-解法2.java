/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */
class Solution {
    
        static Set<Character> set;
    
        static {
            set = new HashSet<>();
            set.add('+');
            set.add('-');
            set.add('*');
            set.add('/');
        }
    
        public static int calculate(String s) {
    
            int num = 0;
            Stack<Integer> stack = new Stack<>();
            char sign = '+';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                }
                if (set.contains(c) || i == s.length() - 1) {
                    if (sign == '+') {
                        stack.push(num);
                    } else if (sign == '-') {
                        stack.push(-num);
                    } else if (sign == '*') {
                        int tmp = stack.pop() * num;
                        stack.push(tmp);
                    } else if (sign == '/') {
                        int tmp = stack.pop() / num;
                        stack.push(tmp);
                    }
                    sign = c;
                    num = 0;
                }
            }
            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        }
    
}


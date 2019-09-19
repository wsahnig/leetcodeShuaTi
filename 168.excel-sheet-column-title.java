/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */
class Solution {
    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        
        while(n != 0){
            int offset = --n % 26;
            title.append((char)('A' + offset));
            n /= 26;
        }
                
        return title.reverse().toString();
    }
}


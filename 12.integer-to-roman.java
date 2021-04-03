/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 *
 * https://leetcode.com/problems/integer-to-roman/description/
 *
 * algorithms
 * Medium (49.85%)
 * Total Accepted:    207.5K
 * Total Submissions: 415.7K
 * Testcase Example:  '3'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: "III"
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "IV"
 * 
 * Example 3:
 * 
 * 
 * Input: 9
 * Output: "IX"
 * 
 * Example 4:
 * 
 * 
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */
class Solution {
    public String intToRoman2(int num) {
        String[] M = new String[] { "", "M", "MM", "MMM" };
        String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
    public String intToRoman(int num) {
       String roman = "";
       while(num >= 1000){
           num -= 1000;
           roman += 'M';
       }
       while(num >= 900){
           num -= 900;
           roman += "CM";
       }
       while(num >= 500){
           num -= 500;
           roman += 'D';
       }
       while(num >= 400){
           num -= 400;
           roman += "CD";
       }
       while(num >= 100){
           num -= 100;
           roman += 'C';
       }
       while(num >= 90){
           num -= 90;
           roman += "XC";
       }
       while(num >= 50){
           num -= 50;
           roman += 'L';
       }
       while(num >= 40){
           num -= 40;
           roman += "XL";
       }
       while(num >= 10){
           num -= 10;
           roman += 'X';
       }
       while(num >= 9){
           num -= 9;
           roman += "IX";
       }
       while(num >= 5){
           num -= 5;
           roman += 'V';
       }
       while(num >= 4){
           num -= 4;
           roman += "IV";
       }
       while(num >= 1){
           num -= 1;
           roman += 'I';
       }
       return roman;
    }
}


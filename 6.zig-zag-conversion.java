/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (30.77%)
 * Total Accepted:    290.5K
 * Total Submissions: 944K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    // 2*numRows-2
    // 
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        if(numRows == 1 || numRows == len) return s;
        
        int step = 0;
        int maxStep = 2*(numRows-1);
            
        for(int i=0; i<numRows; i++){
            int j = i;
            if(i == 0 || i == numRows-1)
            {
                step = maxStep;
                while(j < len)
                {
                    sb.append(s.charAt(j));
                    j += step;
                }
            }
            else
            {
                step = maxStep-2*i;
                while(j < len)
                {
                    sb.append(s.charAt(j));
                    j += step;
                    step = maxStep-step;
                }
            }
        }
        return sb.toString();
    }
}


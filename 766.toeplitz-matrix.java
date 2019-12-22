/*
 * @lc app=leetcode id=766 lang=java
 *
 * [766] Toeplitz Matrix
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int value,x,y;
        for(int i=0;i<n;i++){
            value = matrix[0][i];
            x = 1;
            y = i+1;
            while(x<m && y<n){
                if(matrix[x++][y++] != value) return false;
            }
        }
        for(int i=1;i<m;i++){
            value = matrix[i][0];
            x = i+1;
            y = 1;
            while(x<m && y<n){
                if(matrix[x++][y++] != value) return false; 
            }
        }
        return true;
        
    }
}
// @lc code=end


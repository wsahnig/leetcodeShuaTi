/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
       if(matrix == null || matrix.length == 0 || matrix[0].length==0)
          return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n;i++){
            if(matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < m;i++){
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))
                       +1;
                    if(dp[i][j] > max) max = dp[i][j];
                }
            }
        }

        return max*max;

    }
}


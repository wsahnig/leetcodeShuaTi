/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    // private int dfs(int[][] matrix,int[][] max,int i,int j,int pre){
    //     if(i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || matrix[i][j] <= pre){
    //         return 0;
    //     }
    //     if(max[i][j] != 0){
    //         return max[i][j];
    //     }
    //     else{   
    //         int down = dfs(matrix, max, i+1, j, matrix[i][j]);
    //         int top = dfs(matrix, max, i-1, j, matrix[i][j]);
    //         int left = dfs(matrix, max, i, j-1, matrix[i][j]);
    //         int right = dfs(matrix, max, i, j+1, matrix[i][j]);
    //         return max[i][j] = Math.max(Math.max(down,top), Math.max(left,right)) + 1; 
    //     }  
    // }

    // public int longestIncreasingPath(int[][] matrix) {
    //     if(matrix == null || matrix.length == 0) return 0;
    //     int[][] dp = new int[matrix.length][matrix[0].length];
    //     int longestLength = 0;
    //     for(int i = 0; i < matrix.length; i++){
    //         for(int j  =0; j < matrix[0].length; j++){
    //             if(dp[i][j] == 0)
    //               dp[i][j] = dfs(matrix, dp, i, j, matrix[i][j] - 1);

    //             longestLength = Math.max(dp[i][j], longestLength);
    //         }
    //     }
    //     return longestLength;
    // }
    final int[] dirs = new int[]{0, 1, 0, -1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(len, max);
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int row, int col, int[][] cache) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dirs[i];
            int nextCol = col + dirs[i + 1];
            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length || matrix[nextRow][nextCol] <= matrix[row][col]) {
                continue;
            }
            int len = 1 + dfs(matrix, nextRow, nextCol, cache);
            max = Math.max(max, len);
        }
        cache[row][col] = max;
        return max;
    }
}
// @lc code=end


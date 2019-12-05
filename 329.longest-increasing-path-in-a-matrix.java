/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    private int dfs(int[][] matrix,int[][] max,int i,int j,int pre){
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || matrix[i][j] <= pre){
            return 0;
        }
        if(max[i][j] != 0){
            return max[i][j];
        }
        else{
            
            int down = dfs(matrix,max,i+1,j,matrix[i][j]);
            int top = dfs(matrix,max,i-1,j,matrix[i][j]);
            int left = dfs(matrix,max,i,j-1,matrix[i][j]);
            int right = dfs(matrix,max,i,j+1,matrix[i][j]);
            return max[i][j] = Math.max(Math.max(down,top),Math.max(left,right))+1; 
        }  
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int longestLength = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(dp[i][j] == 0)
                  dp[i][j] = dfs(matrix,dp,i,j,matrix[i][j]-1);

                longestLength = Math.max(dp[i][j],longestLength);
            }
        }
        return longestLength;
    }
}
// @lc code=end


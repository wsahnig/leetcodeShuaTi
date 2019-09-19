/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */
class Solution {
   
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null) return null;
        int m = matrix.length;
        if(m == 0) return null;
        int n = matrix[0].length;
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = Integer.MAX_VALUE - 10000;
                }               
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i > 0){
                    dist[i][j] = Math.min(dist[i][j],dist[i-1][j]+1);
                }
                if(j > 0){
                    dist[i][j] = Math.min(dist[i][j],dist[i][j-1]+1);
                }
            }
        }
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i < m-1){
                    dist[i][j] = Math.min(dist[i][j],dist[i+1][j]+1);
                }
                if(j < n-1){
                    dist[i][j] = Math.min(dist[i][j],dist[i][j+1]+1);
                }
            }
        }
        return dist;
    }
}


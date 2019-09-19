/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */
class NumMatrix {
    private int [][] sum2Ori;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        sum2Ori = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++)
          for(int j=1;j<=matrix[0].length;j++)
             sum2Ori[i][j] = matrix[i-1][j-1]+sum2Ori[i-1][j]+sum2Ori[i][j-1]-
             sum2Ori[i-1][j-1];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sum2Ori == null) return 0;
        return sum2Ori[row2+1][col2+1] 
              - sum2Ori[row2+1][col1]
              - sum2Ori[row1][col2+1]
              + sum2Ori[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


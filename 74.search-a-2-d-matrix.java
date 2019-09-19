/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n= matrix[0].length;
        if(n == 0) return false;
        for(int i=0;i<m;i++){
            if( target >= matrix[i][0] && target <= matrix[i][n-1]){
                int low = 0,high = n-1;
                while(low <= high){
                   int mid = (low + high) / 2;
                   if(matrix[i][mid] == target) return true;
                   else if(matrix[i][mid] > target) high = mid -1;
                   else low = mid + 1;
                }               
            }
        }
        return false;
    }
}


/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        if(m == 0) return false;
        for(int i=0;i<n;i++){
           if(target >= matrix[i][0] && target <= matrix[i][m-1]){
               int lo = 0,hi = m-1;
               while(lo <= hi){
                   int mid = lo + (hi - lo) / 2;
                   if(matrix[i][mid] == target) return true;
                   else if(matrix[i][mid] < target) lo = mid + 1;
                   else hi = mid - 1;
               }
           }  
        }
        return false;
    }
}


/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0,right = n-1,top = 0,bottom = n-1;
        int value = 1;
        while(left <= right && top <= bottom){
             for(int i=left;i<=right;i++){
                 ans[top][i] = value++;
             }
             for(int i=top+1;i<=bottom;i++){
                 ans[i][right] = value++;
             }
             for(int i=right-1;i>=left;i--){
                 ans[bottom][i] = value++;
             }
             for(int i=bottom-1;i>top;i--){
                 ans[i][left] = value++;
             }
             left++;
             right--;
             top++;
             bottom--;
        }
        return ans;
    }
}


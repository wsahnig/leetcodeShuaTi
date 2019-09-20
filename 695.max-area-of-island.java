/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */
class Solution {
    int dfsCount(int[][] grid,int i,int j){
        int count = 0;
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            count++;
            grid[i][j] = 0;
            count = count + dfsCount(grid, i+1, j) + dfsCount(grid, i-1, j)
                    +dfsCount(grid, i, j+1) + dfsCount(grid, i, j-1);   
        }
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if(grid == null) return maxArea;
        int m = grid.length;
        if(m == 0) return maxArea;
        int n = grid[0].length;
        if(n == 0) return maxArea;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int tmp = dfsCount(grid, i, j);
                    if(tmp > maxArea){
                        maxArea = tmp;
                    }
                }
            }
        }
        return maxArea;
    }
}


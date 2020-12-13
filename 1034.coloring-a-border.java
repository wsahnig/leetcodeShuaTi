/*
 * @lc app=leetcode id=1034 lang=java
 *
 * [1034] Coloring A Border
 */

// @lc code=start
class Solution {
    private void dfs(int[][] grid,boolean[][] vis,int r0, int c0, int color,int oldCol){
                
        vis[r0][c0] = true;
        
        if(r0-1 < 0){
            grid[r0][c0] = color;
        }else if(!vis[r0-1][c0]){
            if(grid[r0-1][c0] != oldCol) grid[r0][c0] = color;
            else dfs(grid,vis,r0-1,c0,color,oldCol);     
        }
        
        if(c0-1 < 0){
            grid[r0][c0] = color;
        }else if(!vis[r0][c0-1]){
            if(grid[r0][c0-1] != oldCol) grid[r0][c0] = color;
            else dfs(grid,vis,r0,c0-1,color,oldCol);     
        }
        
        if(r0+1 == grid.length){
            grid[r0][c0] = color;
        }else if(!vis[r0+1][c0]){
            if(grid[r0+1][c0] != oldCol) grid[r0][c0] = color;
            else dfs(grid,vis,r0+1,c0,color,oldCol);     
        }
        
        if(c0+1 == grid[0].length){
            grid[r0][c0] = color;
        }else if(!vis[r0][c0+1]){
            if(grid[r0][c0+1] != oldCol) grid[r0][c0] = color;
            else dfs(grid,vis,r0,c0+1,color,oldCol);     
        }
        
    }
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dfs(grid,vis,r0,c0,color,grid[r0][c0]);
        return grid;
    }
}
// @lc code=end


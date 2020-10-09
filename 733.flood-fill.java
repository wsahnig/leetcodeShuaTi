/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    private void dfs(int[][] image,int sr, int sc,int rows,int cols, int oldColor,int newColor){
        if(sr < 0 || sc < 0 || sr == rows || sc == cols || image[sr][sc]!=oldColor) return;
        image[sr][sc]=newColor;
        dfs(image,sr-1,sc,rows,cols,oldColor,newColor);
        dfs(image,sr,sc-1,rows,cols,oldColor,newColor);
        dfs(image,sr+1,sc,rows,cols,oldColor,newColor);
        dfs(image,sr,sc+1,rows,cols,oldColor,newColor);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];
        if(oldColor != newColor)dfs(image,sr,sc,rows,cols,oldColor,newColor);
        return image;
    }
}
// @lc code=end


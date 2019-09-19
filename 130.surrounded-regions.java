/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */
class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        //从边界的O开始dfs
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O') dfs(i,0,board);
            if(board[i][n-1] == 'O') dfs(i,n-1,board);
        }
        for(int i=1;i<n-1;i++){
            if(board[0][i] == 'O') dfs(0,i,board);
            if(board[m-1][i] == 'O') dfs(m-1,i,board);
        }
        //再次遍历，将被包围的O改为X
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'Y')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
   
    }
    private void dfs(int i,int j,char[][] board){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j]
        == 'O'){
            board[i][j] = 'Y';
            dfs(i+1,j,board);
            dfs(i-1,j,board);
            dfs(i,j+1,board);
            dfs(i,j-1,board);
        }
    }
}


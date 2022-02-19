/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j){
        int m = 9, n = 9;
        if(j == n){
            return backtrack(board, i+1, 0);
        }
        if(i == m)
        {
            return true;
        }

        if(board[i][j] != '.')
        {
            return backtrack(board, i, j+1);
        }

        for(char ch = '1'; ch <= '9'; ch++)
        {
            if(!isValid(board, i, j, ch)) continue;

            board[i][j] = ch;

            if(backtrack(board, i, j+1)) {
                return true;
            }

            board[i][j] = '.';
        }

        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char n)
    {
        for(int i=0; i<9; i++)
        {
            if(board[r][i] == n) return false;
            if(board[i][c] == n) return false;
            //3*3方框 从左到右，从上到下
            if(board[(r/3)*3 + i/3][(c/3)*3 + i % 3] == n) return false;
        }
        return true;
    }
}
// @lc code=end


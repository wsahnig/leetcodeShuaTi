<<<<<<< HEAD
/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (42.09%)
 * Total Accepted:    219.9K
 * Total Submissions: 521.9K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 * 
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being 
 * ⁠   modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * Note:
 * 
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned
 * rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    public boolean judge1(char[][] board){
        for(int i=0;i<9;i++){
            int[] hash=new int[10];
            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                int x = board[i][j] - '0';
                if(hash[x] == 0) hash[x] = 1;
                else return false;
            }
        }
        return true;
    }

    public boolean judge2(char[][] board){
        for(int i=0;i<9;i++){
            int[] hash=new int[10];
            for(int j=0;j<9;j++){
                if(board[j][i] == '.') continue;
                int x = board[j][i] - '0';
                if(hash[x] == 0) hash[x] = 1;
                else return false;
            }
        }
        return true;
    }

    public boolean judge3(char[][] board){
        
       for(int i= 0; i< 9; i=i+3){
           for(int j= 0; j< 9; j=j+3){
             int[] hash=new int[10];

               for(int m=i;m<i+3;m++){
                   for(int n=j;n<j+3;n++){
                    if(board[m][n] == '.') continue;
                    int x = board[m][n] - '0';
                    if(hash[x] == 0) hash[x] = 1;
                    else return false;
                   }
               }
                 
           }
       }
       return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if(!judge1(board)) return false;
        else if(!judge2(board)) return false;
        else if(!judge3(board)) return false;
        else return true;
    }
}
=======
/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
    }
}
>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0


/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */
class Solution {
    public void gameOfLife(int[][] board) {
        int[] move = {-1,0,1};

        int rows = board.length;
        int columns = board[0].length;

        int[][] copy = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                copy[i][j] = board[i][j];
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                int LiveNeighbor = 0;

                for(int r = 0 ; r < 3;r++){
                    for(int c = 0;c < 3;c++){
                         if(r != 1 || c != 1){
                             if(i + move[r] >= 0 && i + move[r] < rows &&
                             j + move[c] >= 0 && j + move[c] < columns &&
                             copy[i + move[r]][j + move[c]] == 1){
                                 LiveNeighbor++;
                             }
                         }     
                    }
                }

                if(board[i][j] == 1 && (LiveNeighbor < 2 || LiveNeighbor > 3)){
                    board[i][j] = 0;
                }
                if(board[i][j] == 0 && LiveNeighbor == 3){
                    board[i][j] = 1;
                }
            }
        }
        
    }
}


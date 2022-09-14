class Solution {
    /**
    
    
     intution behing the problem is try every possible number on each empty cell if it is valid return true. else      back track.
     
     for checking every subbox, row and col for a cell we use only one loop
     
     so for sub box any cell eg (5,7)  (row,col)
     
     formula   board[5][i]    each col
               board[i][7]    each row
              
               [3*row/3 + i/3]  [3*col/3 + i%3]
               
               i=0 j=0;   [3,6][3,7][3,8]
                          [4,6][4,7][4,8]
                          [5,6][5,7][5,8]
     
     
    */
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j] == '.' ){   // if cell is empty
                    
                    for(char c='1';c<='9';c++){
                        
                        if(isValid(board,i,j,c)){   // if move is valid
                             
                            board[i][j] =  c;   // put c in this cell
                            
                            if(solve(board)) return true;   // if it is the solution return
                            
                            board[i][j] = '.';  // back track if not correct
                        }
                     }
                    return false; //  return false if tried everything from 1 to 9
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char [][] board,int row, int col, char c){
        
        for(int i=0;i<9;i++){
            if(board[row][i] == c) return false;  // if exist in entire curr row  , col is flactuating
            if(board[i][col] == c) return false;   //  if exist in entire curr col , row is flatuating
            
            // if exit in particular sub box
            
            if(board[3*(row/3) + i/3] [3* (col/3) + i%3] == c) return false;
        }
        return true;
    }
 }

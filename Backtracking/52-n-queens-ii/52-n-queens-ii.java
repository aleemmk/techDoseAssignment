class Solution {
     int count;
    public int totalNQueens(int n) {
        char board [] [] = new char[n][n];
        
        
        for(char[] brd:board) Arrays.fill(brd,'.');
        
       count=0;
       
      solve(board,0,n);
        
        return count;
    }
    
    private void solve(char [][] board,int col,int n){
       
        if(col == n){
            count++;
          return;
        }
        for(int i=0;i<n;i++){
            if(validate(board,i,col)){  
              
                 board[i][col] = 'Q';   // putting queen on first column of every cell;
                 solve(board,col+1,n);
                 board[i][col] ='.';   // backtrack
            
            }
            
        }
    }
    
    
    private boolean validate(char[][] board, int row, int col){
        int i; int j;
        
        
        // check this row on left side
        for( i=0;i<col;i++){
            if(board[row][i] == 'Q')
                return false;
        }
        
        // check upper diagonal on left side
        for(i=row,j=col; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }
            
        // check lower diagonal on left side
        
        for(i=row,j=col;i<board.length && j>=0;i++,j--){
            if(board[i][j] == 'Q')
                return false;
        }
        
        return true;
    }
}
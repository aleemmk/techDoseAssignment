class Solution {
    /**
      As per rule of suduku each row and col and and subbox(3X3) can only have unquie nuber ranging (1-9).
      
      it is partially filled .
      
      we can use hashing here because it conaints unique elements.
    */
    
    public boolean isValidSudoku(char[][] board) {
      
        HashSet<String> seen = new HashSet<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char num = board[i][j];
                if( num !='.' ){
                
                if(!seen.add(num +"seen in row "+i) ||
                   !seen.add(num+"seen in col "+j)  || 
                   !seen.add(num+"seen in col"+i/3+ "and row"+j/3) ) return false;
              }
            }
        }
        
        return true;
    }
}
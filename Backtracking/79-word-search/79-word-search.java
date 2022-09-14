class Solution {
    
    /**
         need to check for all cell of grid with start char of word if find then look every direction for the 
         next word . if not find the recurive calls then back track 
         
         TC
         O(M*N*4L)
         
         space O(L)
    */
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        int dirs [][] = {
            {-1,0},
            {1, 0},
            {0, 1},
            {0,-1}
        };
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                
                if(isExist(board,i,j,word,dirs,0)) return true;
            }
        }
        return false;
    }
    
    private boolean isExist(char[][] board , int i, int j,String word,int dirs[][],int start){
        
        if(start == word.length()) return true;
        
    if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 || board[i][j] != word.charAt(start)) 
              return false;
        
        board[i][j] ='#';   // visited this cell;
        
        char c = word.charAt(start);
        boolean res = false;
        for(int[] dir:dirs){
            int x = dir[0];
            int y = dir[1];
            
           res |= isExist(board,i+x,j+y,word,dirs,start+1);
            
            if(res) return true;   // if any time find the word instantly return true
            
        }
        board[i][j] =c ;   // backtrack;
        
        return res;
        
        
    }
}
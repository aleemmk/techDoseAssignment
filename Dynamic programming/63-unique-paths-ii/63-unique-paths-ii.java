class Solution {
    
    /**
       0     1
      ----------
    0 | S  | y  |
      -----------
     1|  x |  E |
     ------------
     
      total number of ways to reach from s to E is    x+y 
     so if obstacle is not present then for a particular cell (i,j) total number of way to reach is
     
     cell(i,j) = cell(i-1,j) + cell(i ,j-1)
     
     so for 1st row and 1st col there is only 1 ways to reach at end.
     if obstacle is presnet then next cell in row or col is unreachable.
     
     TC
     O(row*col)
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int dp [] [] = new int [row][col];
        
        boolean flag = false;
        // for first row 
        for(int i=0;i<col;i++){
            
            if(flag || obstacleGrid[0][i]==1){
                flag= true;
                dp[0][i] = 0;
            }else{
                dp[0][i] = 1;
            }
            
        }
          flag = false;
        // for first col
        for(int i=0;i<row;i++){
            if(flag || obstacleGrid[i][0] ==1){
                flag= true;
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
            }
        }
        
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                
                if(obstacleGrid [i][j] ==1)  
                     dp[i][j] = 0;    // if got obstacle mark current cell  0 unreachable
                else
                dp[i][j]  = dp[i-1][j]+dp[i][j-1];  // sum of left and top cell
            }
        }
        
        return dp[row-1][col-1];
    }
}
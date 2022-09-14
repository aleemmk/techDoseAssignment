class Solution {
    
    /**
       0     1
      ----------
    0 | S  | y  |
      -----------
     1|  x |  E |
     ------------
     
     we can reach y only one way from left so cost at cell y is s+y
     we can reach x onoy one eay from top  so cost at cell x  is s+x
     
     so cost of reaching at E is  cost(E) = E + min(s+y,s+x);
     
     so at col 0 and row 0 at each cell  there is only one way from s to reach so the cost is comulative sum of row0 or        col 0
     
     here greedy approach will not work because if we greedily pick min cost and decide a path so there may be lower cost 
     incured in other path which we have not chosen.
     
     we can solve this problem with recusion by TC is 2^n.
     
       minPath(grid,x,y){
       // base case
       return grid[i][j] + min( minPath(grid,i+1,j)+ minPath(grid,i,j+1));
       }
     
     this problem have overlapping subproblem we can apply dp.
     
     dp with tabulation 
     
    */
    public int minPathSum(int[][] grid) {
        
        int rows =  grid.length;
        int cols = grid[0].length;
        
        int dp [][] = new int [rows][cols];
        
        dp[0][0] = grid[0][0];
        
        // fill first row
        for(int i=1;i<cols;i++){
            
            dp[0][i] = dp[0][i-1] + grid[0][i];  // left cell + current cell
        }
        // fill firs col
        for(int i=1;i<rows;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];   // top col + current col
        }
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                
                dp[i][j] = grid[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        
        return dp [rows-1][cols-1];
    }
}
class Solution {
    
    /**
    [[-10]]  =  ans = 1+(-(-10));
    [[10]]   = ans = 1; atleast we required 1 to reach the cell;
    [[10,20,30,40,50]]  ans =1
    [[-2,-3,3,-5,-10]]   : ans = 1 + (-(-17)) = 18
    
    
    */
   /* public int calculateMinimumHP(int[][] dungeon) {
        
        
        int i=0;
        int j=0;
        return minHealth(dungeon,i,j);
    }
    
    private int minHealth(int [][] dungeon,int i,int j){
      int rows = dungeon.length;
       int cols = dungeon[0].length;
        
      if(i==rows || j==cols) return Integer.MAX_VALUE;   // out of bound
        
        if(i==rows-1 && j==cols-1) return  dungeon[i][j] >=0 ? 1: -dungeon[i][j] + 1;  // base case
        
        int ifMoveRight = minHealth(dungeon,i,j+1);
        int ifMoveDown =  minHealth(dungeon,i+1,j);
        
        int needHealth = Math.min(ifMoveRight,ifMoveDown) - dungeon[i][j];
        
        return needHealth <=0 ? 1:needHealth;
        
    }
    */
    /**
      ---------------
     | -6 | -4  | -1 |
      ---------------
     | -5 | -10 | -4 |
     ------------------
     | 0  | 0  | -5  |
      -----------------
     
    */
    
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        
      int dp[][] = new int[rows][cols];
        
        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                
                if(i==rows-1 && j==cols-1){
                    dp[i][j] = Math.min(0,dungeon[i][j]);
                }else if(i== rows-1){   // last row
                   dp[i][j] = Math.min(0,dp[i][j+1]+dungeon[i][j]);
                }else if(j==cols-1) {   // last col
                    dp[i][j] = Math.min(0,dp[i+1][j]+dungeon[i][j]);
                }else{
                    dp[i][j] = Math.min(0,+dungeon[i][j]+Math.max(dp[i+1][j],dp[i][j+1]));
                }
            }
        }
        return Math.abs(dp[0][0])+1;
    }
}
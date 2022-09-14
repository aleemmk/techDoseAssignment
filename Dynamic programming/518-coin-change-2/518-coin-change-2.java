class Solution {
    /**
    
     each coin have two option either to include or exclude
     
     i-> count
     j-> amount
     
     to construct dp[][]
     
       dp[i][j] = dp[i-1][j]  exclude the coin , if exclude current coin then see above row on same column 
       
       
       when we include current coin j it means (j-coins[i-1] ) amount still need to be made so we go to that column and see      the ways of doing this. 
    
     dp[i][j] = dp[i][j-coins[i-1]]    include
     
     so if current amount j >= coins[i-1]   we have to include else exclude (coins[i-1] is the current coin started with index 1 )
    */
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        
        int dp [][] = new int [n+1][amount+1];
        
        for(int i=1;i<=amount;i++){
            dp[0][i] = 0;           // started with 1 because 0 amount always be made with exclude everthing so 1 way
        }
        
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;     // by selecting 0 coin 1 ways of making zero amount;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                
                if(j >= coins[i-1]){ 
                    // include curr coin
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]; // total way of including+excluding curr coin 
                }else{
                    // must exclude curr coin
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        return dp[n][amount];
    }
}
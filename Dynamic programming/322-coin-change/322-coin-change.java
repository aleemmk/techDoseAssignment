class Solution {
    
    /**
      This the example of unbounded knapsak problem
      
      This problem states unlimited supply of coin. and each coin have two choice to include or not to include
      
      amount equivalne tto weight inside knapsak.
      
      so normal recusive function is to have O(2^n) TC . 
      
      
      two boundry cases"
      
      coin = 0 (no coin ) and amount >  0  in that case it is impossible return infinity
      
      amount =0  return 0 means we form 0 amount by selecting zero coin
      
      not include  dp[i][j] =  dp[i-1][j]
      
      include   dp[i][j]  = 1 + dp [i][j-coin[i-1]] ;
      
            
    */
    public int coinChange(int[] coins, int amount) {
        
       int n = coins.length;
        int dp[][] = new int [n+1][amount+1];
        
        for(int i=0;i<=n;i++){    // coin
            
            for(int j=0;j<=amount;j++){    // amount
                
                
                  if(i==0) dp[i][j] = 1000000;   // boundry 1
                
                else if(j==0) dp[i][j] =  0;    // boundry 2;
                else if(coins[i-1] > j)        // couns[i-1] is current coin as start with 1 index
                    dp[i][j] =  dp[i-1][j];     // no include
                else
                    dp[i][j]  = Math.min(dp[i-1][j], (1 + dp[i][j-coins[i-1]]));  // min(include,not include)
                
            }
        }
        
        return dp[n][amount] > 1e5 ? -1: dp[n][amount]; 
    }
}
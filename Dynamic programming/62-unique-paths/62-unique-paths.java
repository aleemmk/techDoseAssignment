class Solution {
    
    /**
       
    */
    public int uniquePaths(int m, int n) {
        
     //  dp formula
    //  result (i,j) = result(i+1,j)+result(i,j+1);
        
        int dp [][] = new int [m+1][n+1];
        
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                
                if(i==0 || j== 0){
                    dp[i][j] = 1;     //there is only one way to to reach when i =0 or j=0
                }
                if(i>0 && j>0)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];       // total no of ways at (i,j) is sum of (i-1,j) and (i,j-1) 
                // sum of top cell and left cell
                
            }
        }
        return dp[m-1][n-1];
    }
}
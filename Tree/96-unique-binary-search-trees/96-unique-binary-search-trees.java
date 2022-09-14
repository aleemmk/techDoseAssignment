class Solution {
    
    /**
    f(2) = f0*f1 + f1*f0;
    f(3) = f0*f2 + f1*f1 + f2*f0;
    f(4) = f0*f3 + f1*f2 + f2*f1 + f3*f0;
    
    above series is a catalon number
          n-1
    fn =  SUMMATION fi *fn-i1
          i=0
          
      1,1,2,5,14
    dp = [1, 1, 2, 5];
          f0,f1,f2,f3
    dp [] = [1,1,2,5]
    
    n=4
    i=2 
    j=0
    dp[2] = 0
    dp[2] += dp[0]*dp[1];
    
    i=2
    j=1
    dp[2] = 1;
    dp[2] = 1+ dp[1]*dp[1];
    dp[2] = 2;
    
    i=3
    j=0
    dp[3] = 0+dp[0] * dp[2];
    .
    .
    .
    .
    
    
    */
    public int numTrees(int n) {
        
        int dp[] = new int[n+1];
        
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i] = 0; // intialize by a zero.
            
            for(int j=0;j<i;j++){   // start with 0 to i-1(inclusive)
                dp[i] = dp[i] + dp[j]* dp[i-j-1];
            }
        }
        return dp[n];
     }
    
}
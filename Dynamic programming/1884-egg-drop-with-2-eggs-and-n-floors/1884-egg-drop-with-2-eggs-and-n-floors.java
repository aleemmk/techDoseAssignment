class Solution {
    
    /**
    
    */
    public int twoEggDrop(int n) {
     int e = 2;
        int dp [] [] = new int [e+1][n+1];
     // 
            
            for(int i=0;i<dp.length;i++){
                Arrays.fill(dp[i],-1);
            }
        return eggDrop(e,n,dp);
    }
    
    private int eggDrop(int e,int n,int dp[][]){
        // e egg and n floor
        
        if(dp[e][n] !=-1) return dp[e][n];
        
        if(n == 0 || n==1)
            return n;
        
        if(e==1) return n;  // if egg is one we tried all floor so qual to number of floor
        
         // suppose we drop it from k floor k is raging from 1 to n 
        //   two cases break = 1+eggDrop(e-1,n-1)
                // not break = 1+eggDrop(e,n-k)  taking worse case
        int res = Integer.MAX_VALUE;
        
        for(int k=1 ; k<=n ;k++){
            
            int moves = 1+Math.max(eggDrop(e-1,k-1,dp),eggDrop(e,n-k,dp));
            
            res = Math.min(moves,res);
            
        }
        return  dp [e][n] = res;
    }
}
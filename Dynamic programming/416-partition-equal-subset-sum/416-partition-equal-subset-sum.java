class Solution {
    /**
       if sum of all the element of array is s so 
       
       s1 is the sum of set 1 
       s2 is the sum of set 2
        
        s1+s2 = s   and s1=s2 so   sum of each set is s/2 . 
      
      problem is converted into sum of subset equal to target sum .
      
      if we find one set then oviusly remaining element is in another set.
      
      but s is odd it means we can't devide into two subset of equal sum .
      
      subset sum is the 0/1 knapsack probem for each element we have two choice
      
                    each element i 
                     -      -
                    -       -
                   -          -
                   -           -
                 -               -
             not include        
          curr ele > target      curr  >= target
                                 i) inculede if taking curr then equal to target
                                 ii) not include is by taking curr not equal to target
                                   OR on both condition
                                
     */
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        int n = nums.length;   // i
        
        for(int i=0;i<n;i++) sum += nums[i];
        
        if((sum & 1) == 1) return false;
        
        sum = sum/2;  // j
        
        boolean dp [] [] = new boolean [n+1][sum+1];
        
        for(int i=0;i<=n;i++) dp[i][0] = true;
        
        for(int j=0;j<=sum;j++) dp[0][j] = false;
        
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=sum;j++){
                
                 if(nums[i-1] > j) dp[i][j] = dp[i-1][j];
                
                else if(j >= nums[i-1])
                    dp[i][j] =  dp[i-1][j] || dp[i-1] [j-nums[i-1]];
                
                
            }
        }
        
        return dp[n][sum];
    }
}
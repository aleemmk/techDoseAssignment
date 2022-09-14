class Solution {
    /**
     This is the problem of longest common substring.
     
      	      0  1  2  3  4  5
        i\j |    a  b  b  a  c  
            --------------------
        0   | 0  0  0  0  0  0
        1 a | 0  1  0  0  1  0
        2 b | 0  0  2  0  
        3 b | 0 
        4 a | 0 
        5 c | 0
        
        s1 [i-1] == s2[j-1]
          1+s[i][j]             diagonal     
    */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int maxlen = 0;
        
        if(m==0 || n==0) return 0;
        
        int dp [][] = new int [m+1][n+1];
        
        for(int i=0;i<= m;i++){
            for(int j=0;j<= n;j++){
                
                if(i==0 || j==0)  dp[i][j] = 0;
                
              else if(nums1[i-1] == nums2[j-1]){
                    dp[i][j]= 1+ dp[i-1][j-1];  // diagonal element
                    maxlen = Math.max(maxlen,dp[i][j]);
                } else
                        dp[i][j] =0;
            }
        }
        
    return maxlen;
    }
}
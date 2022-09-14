class Solution {
    /**
      
      s1 = abc     m length
      s2 = bcc     n length
      
      we have three operation here 
      
      here we start with last character
      
      1. it is matching no operation is need
      s1 = abc    m
      s2 = bcb    n
      
      2. not matching either delete or insert
         delete    m-1 ,n
         insert    m , n-1
         
         boundry cases
         s1=abc  m
         s2=""   n =0  here return m operation
         
         s1= ""    m=0
         s2 "bcb"  n    here return n operation
            b     c    d
   s1    0  1     2    3
      --------------------
s2  0 | 0 | 1  | 2 | 3    |
      --------------- ----
 a 1  | 1 | 1  |  2|  3   |
      ---------------------
 b 2  | 2  | 1  | 2  |3   |
      --------------------
  d 3 | 3  | 2  | 2  | 2  |
      --------------------
      
      m==0 return n
      n=0 return n
      
      charAt[m-1] == charAt[n-1]  copy diagonal no operation
      else if
         1+ min(previous top cell, left cell, diagonal cell )  or min(inset,delete,match)
         
    */
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        int dp [] [] = new int [m+1][n+1];
        for(int i=0 ;i<=m;i++){
            for(int j=0;j<=n;j++){
               
                if(j==0)
                 dp[i][j] = i;
                
                else if(i==0)
                    dp[i][j] = j;
                
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1+ Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
        
    }
}
class Solution {
    int memo [] [] ;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char arr1 []= word1.toCharArray();
        char arr2 []= word2.toCharArray();
        int dp [][] = new int [m+1] [n+1];
        
        for(int i=0 ; i<m+1;i++){
            for(int j=0 ; j<n+1;j++){
                
                if(i==0 && j==0)
                    dp[i][j] = 0;
                else if(i==0)
                    dp[i][j] = dp[i] [j-1]+1;
                else if(j==0)
                    dp[i][j] = dp[i-1][j]+1;
                else if(arr1[i-1] == arr2[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                  dp [i][j] = Math.min(dp[i][j-1], dp[i-1] [j] )+1;
                   
                }
            }
           return dp [m][n];
        
    }
    
	/*public int lcs(char P[], char Q[], int n, int m) {
        int result ;
        if(memo[n][m] != 0) {
        	return memo[n][m];
        }
		if (n == 0 || m == 0) {
			return 0;
		}
		if (P[n-1] == Q[m-1]) {
			result = 1 + lcs(P,Q,n-1,m-1);
		} else {
			result = Math.max(lcs(P, Q, n-1, m), lcs(P, Q, n, m-1));
		}
		memo[n][m]= result;
	
		return result;
	}*/
}
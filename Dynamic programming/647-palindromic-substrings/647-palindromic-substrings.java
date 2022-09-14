class Solution {
    /**
        	  0  1  2  3  4
        i\j | a  b  b  a  c  
            --------------------
        0 a | T  F  F  T  F
        1 b | F  T  T  F  F 
        2 b | F  F  T  F  F
        3 a | F  F  F  T  F
        4 c | F  F  F  F  T
        
    */
    public int countSubstrings(String s) {
        int n = s.length();
        if(n==0) return 0;
       
        boolean dp[][] = new boolean [n+1][n+1];
        
        int res = 0;
        
        // for diagonal when substring length is 1
        
        for(int i=0;i<n;i++){
            dp[i][i] = true;
            res++;
        }
    
        // for length 2 
        
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                res++;
            }
        }
        
    // for 3 onward we need to check   s.charAt(i) == s.charAt(j)  and dp[i+1][j-1] == TRUE
        
        for(int len=2;len<n;len++){
            for(int i=0;i+len<n;i++){  // control the start index
                int j = i+len;   // control end index
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        
        return res;
    }
}
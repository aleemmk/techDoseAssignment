class Solution {
    /**
      brute force
      leetcode
      check l is present in disctonary and recursively check for rest
      
      f(leetcode,0,dict)
        |
       f(eetcode,0,dict)
       
    */
    
    boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> dict = new HashSet<>(wordDict);
        
       //return breakRecur(s,0,dict);
        dp  = new boolean [s.length()+1];
        
       return  wordBreakDp(s,dict);
    }
    
    private boolean wordBreakDp(String s , Set<String> dict){
       dp[0]= true;
        
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] =true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    /*private boolean breakRecur(String s ,int start,Set<String> dict){
        
        if(start == s.length())
               return true;
        
        for(int end= start+1;end<=s.length();end++){
            
            if(dict.contains(s.substring(start,end)) && breakRecur(s,end,dict))
                   return true;
        }
        return false;
       
        
    }*/
}
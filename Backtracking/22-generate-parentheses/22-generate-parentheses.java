class Solution {
    /**
    for generate valid parenthesis we start with "(".
    
    we can keep on selecting "(" as much we want until it all exhaust ,equal to n.
    
    but we can chose closing parenthesis only when 
    
    open parenthesis > close parenthesis
    
    base case
    
    open ==close ==n 
    
    Note : TOTAL NUMBER OF COMBINATION IS CATALAN NUMBER
    
       [""]
       /  
      [( ] 
      /  \
    [(( ] [()]
     /  \
  [(((] [(()]
  /
 [((()] 
    */
     
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        generate(0,0,n,"",ans); 
        return ans;
    }
    
    private void generate(int close,int open,int n ,String s,List<String> ans){
        
        if(open == n && close == n ){
            ans.add(s);
        }
        
        if(open < n){
            generate(close,open+1,n,s+"(",ans);
        }
        
        if(open > close){
            generate(close+1,open,n,s+")",ans);
        }
    }
}
class Solution {
    /**
                  23     ""
                       /  |    \                 
                      a   b     c
                     /|\  /|\   /|\
                    d e f d e f d e f 
                    
                    
    */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0 || digits== null) return ans;
        HashMap<Character, String> map = buildMap();
        
        solve(map,0,digits,ans,"");
        return ans;
    }
    
    private void solve(HashMap<Character, String> map ,int index,String digits,List<String> ans,String res){
        
        if(index == digits.length()) {
            ans.add(res);
            return ;
        }
        
          String letters =  map.get(digits.charAt(index));
        
        for(int i=0;i<letters.length();i++){
           String newString = res + letters.charAt(i);
             solve(map,index+1,digits,ans,newString);
            
        }
        
    }
    
    private HashMap<Character, String> buildMap(){
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }
}
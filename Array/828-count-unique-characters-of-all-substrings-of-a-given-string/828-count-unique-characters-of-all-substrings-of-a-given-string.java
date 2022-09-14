class Solution {
    /**
     0 1 2 3 4 5 6 7
    "L  E  E T C O D E"
     <->
     <-->
     <----->
     <------->
     <---------->
     
     ABCD   10
   
    A 1* 4 = 4
    B 2*3 = 6
    C 3*2 = 6
    D 4*1 = 4
    =========
           20
     
     A        1
     AB       2
     ABC      3
     ABCD     4
     B        1
     BC       2
     BCD      3   
     C        1
     CD       2
     D         1
     ============
             20
     ============
      ABCCD
      A B C C D 
     
      A 1* 5 = 5
      B 2*4 = 8
      D 5*1 = 5
TOTAL C 3+2 = 5
==================
            23
      
      FIRS C
      3*1 = 3
      SECODN C
      1*2 = 2
     ----------
      
     
     
     CD = 2  TOTAL 8
     
     ABCC'D   15
     
     A      1 
     AB     2
     ABC    3
     ABCC   2
     ABCCD  3
     B      1
     BC     2
     BCC    1
     BCCD  2
     C     1
     CC    0
     CCD   1
     C   1
     CD  2
     D   1
     =======
         23
      
      2262. Total Appeal of A String    FOLLOW UP
      */
    
    public int uniqueLetterString(String s) {
        
        HashMap<Character,List<Integer>> map = new HashMap<>();
        
        //  put character as a key and all its index in string added in list.
        
        for(int i=0;i<s.length();i++){
           map.putIfAbsent(s.charAt(i),new ArrayList<>());
           map.get(s.charAt(i)).add(i);
        }
        
        int res = 0;
        for(Character key:map.keySet()){
            List<Integer> index = map.get(key);
            
           for(int i=0;i<index.size();i++){
               int left = i==0 ? index.get(i) + 1 : index.get(i) - index.get(i-1);
               int right = i==index.size()-1 ? s.length() - index.get(i): index.get(i+1) - index.get(i);
                res += (left * right);
           }
            
        }
        return res;
    }
}
class Solution {
    
    /** i,  j
     s= c b a e b a b a c d   n
        0 1 2 3 4 5 6 7 8 9
     p =  a b c ;    m
     
     TC(mn)
     
     winlen =3;
     
    
    
    */
    public List<Integer> findAnagrams(String s, String p) {
        
        int scount [] = new int [26];
        int  pcount[] = new int [26];
        List<Integer> res = new ArrayList<>();
        
         
        
       int winlen = p.length();
        int n = s.length();
        int  left=0;
        int right=0;
        
        if(winlen > n) return res;
        
           for(int i=0;i<winlen;i++){
                pcount[p.charAt(i)-'a']++; 
                scount[s.charAt(i)-'a']++; 
           }
        
        right = left+winlen-1;    // pointer at end of first window length;
        
        
      
        
        while(right < n){
            
            if(isSame(scount,pcount))res.add(left);
            
            right++;  // slide end pointer on window by one
            
            if(right !=n)
              scount[s.charAt(right)-'a']++;  // add nex right char count for slide 
            
            scount[s.charAt(left)-'a']--;   // remove extreme left char count and slide in next step
            
            left++;    // slide start pointer of window by one  to matain winlen
                
        }
        
        return res;
     }
    private boolean isSame(int scount [],int pcount []){
        for(int i=0;i<26;i++){
            if(scount[i] != pcount[i]) return false;
        }
        return true;
    }
}
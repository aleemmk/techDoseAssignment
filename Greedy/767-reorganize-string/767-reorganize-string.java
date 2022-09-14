class Solution {
    /**
     s="aab"
        a b a
        0 1 2
      a is max frequency and even position for above.
      
      STEPS
      1.  count frequency of char and store in count[];
      2.  highest freq  char should put on even position.
      3.  put rest of character
    */
    public String reorganizeString(String s) {
        
        int count [] = new int [26];
        
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;   // frequency count
        }
        int max = 0 ;
        int letter = 0;
        for(int i=0;i<26;i++){
           
            
            if(max < count[i] ){
                max = count[i];   // max count of a char in string
                letter = i;        //  letter of max count
            }
        }
        
        if(max > (s.length()+1)/2) return "";    // need to place at even position if max is more than even place then same char must be adjacent
        
        int idx=0;   // firs teven pos
        char res[]= new char[s.length()];
        
        while(count[letter] > 0){
            
            res[idx] =  (char) (letter +'a');
            idx +=2;     // keep on iterating even pos
            count[letter]--;     // decrese freq in map
        }
        
        
        
        for(int i=0;i<count.length;i++){
            
               while(count[i] > 0){
                    
                    if(idx >= s.length()) idx=1;  // if idx ar last position of beyound boundry pick it first                         odd place as it is empty
                   
                    res[idx] = (char) (i+'a');   
                    idx +=2;    // if even place left pick char when reach end start with 1 index from above
                    count[i]--;
                    
                }
        }
        
        return String.valueOf(res);   // resturn res string from array
    }
}
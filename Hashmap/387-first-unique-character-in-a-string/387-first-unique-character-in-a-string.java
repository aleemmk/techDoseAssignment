class Solution {
    /**
    s = "loveleetcode";
    
    l is not unique repeating.
    o is not unique repeating.
    v in not repeating and occurs first return as answer.
    
    maintin character count array of string.
    return first character from left index whose count is 1.
    */
    

    
    public int firstUniqChar(String s) {
        
        int count [] = new int [26];
        
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            
            if(count[s.charAt(i)-'a'] == 1)
                return i;
        }
        return -1;
    }
}
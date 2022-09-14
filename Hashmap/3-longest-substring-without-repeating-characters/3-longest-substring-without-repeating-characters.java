class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char count [] = new char[256];
    
        int start=0;
        int end = 0;
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            
             count[s.charAt(i)]++;
            
            while(count[s.charAt(i)] > 1)
            {
                count[s.charAt(start)]--;
                start++;
                
            }
            
            
            ans = Math.max(ans,end-start+1);
            end++;
            
        }
        return ans;
    }
}
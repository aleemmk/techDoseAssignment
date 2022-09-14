class Solution {
    
    /**
      ----------------j
      ------------j
      ---------j
      ------  
      prev j
     [1,   3, 5 , 4 , 7]
     
 LIS [1,   2, 3, 3,   4]
 count[]
    */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int count [] = new int [n];
        int LIS[] = new int[n];
        
        Arrays.fill(LIS,1);   
        Arrays.fill(count,1);
        
        for(int j=1;j<n;j++){
            for(int prev=0; prev < j ;prev++){
                
                if(nums[prev] < nums[j] && LIS[prev]+1 > LIS[j]){
                    
                    LIS[j] = 1+LIS[prev];
                    count[j] = count[prev];
                    
                }else if(nums[prev] < nums[j] && LIS[prev]+1 == LIS[j]){
                    count[j] += count[prev];
                }
                
            }
        }
                              
       int maxLength = Integer.MIN_VALUE;
                   
        for(int lis:LIS){
            maxLength  = Math.max(maxLength,lis);
        }
        int cunt=0;
        
          for(int i=0;i<LIS.length;i++){
              if(LIS[i]==maxLength)  cunt += count[i];
          }
                           
        return cunt;                    
                              
    }
}
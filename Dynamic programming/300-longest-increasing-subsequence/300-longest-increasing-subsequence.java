class Solution {
    
    /**    i j 
    arr  [10,9,2,5,3,7,101,18]
          0  1 2 3 4 5  6   7
          single element is always a increasing sequence of length 1 so
          LIS array initilize by 1.
          1. arr[j] > arr[i]  increasing 
           and LIS[i]+1 > LIS[j] 
            LIS(j) = 1+LIS[i]
            
    LIS  [ 1,1,1,2,2,3,4,1]     
    
    
      i----------------j
      i------------j
      i---------j
      ------  
      i    j
  arr [1,   3, 5 , 4 , 7]
     
 LIS [1,   2, 3, 3,   4]
      
    */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int LIS [] =new int[n];
        
       // LIS[0]=1;
        Arrays.fill(LIS,1);
        
        for(int j=1; j<n; j++){
             
          //  LIS[j] = 1;
            
            for(int i=0;i<j;i++){
                
                if(nums[j] > nums[i] && LIS[i]+1 > LIS[j])
                    LIS[j] =1+LIS[i];
            }
        }
        
        int maxLen = Integer.MIN_VALUE;
        
         for(int lis:LIS) maxLen = Math.max(maxLen,lis);
        
        return maxLen;
    }
}
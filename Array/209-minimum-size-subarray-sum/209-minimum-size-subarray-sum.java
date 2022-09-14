class Solution {
    
    /**               i=0 1 2 3  4  5
    target = 7, nums = [2,3,1,2, 4, 3]
    
                        2 5 6 8 12 15
                        
     Brute force :
     we check for every sub array if sum is >= target we keep length and return the minimum length;
     
     but the TC is O(n^2) .according to constraint 10^5 computation so n^2 will give TLE.so atleast 
     O(nlogn)  is accepted or better O(n).
     
     
     
     Approach 2
     1 <= nums[i] <= 104   
     by the constaraint all number is positive so we can apply variable size sliding window
     
     step 1. we take two boundry sliding variable size window left and right bothe start from 0.
     step 2. we keep moving right bounry utill we found sum >=target . window size here is  (right-left+1)
     step 3. now we keep on moving left pointer to shrink the window untill sum < target
      
      now window size (right-left+1)+1 because left pinter will inside the window.
      
      NOTE: if we plot a cumulative sum graph with non negative array then it is monotonically increasing
      and above sliding window technique (two ptr) is used for monotonically increasing fn.
    */
    
    
    
     public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
         int left=0;
         int right=0;
         int sum = 0;
         int winLen=Integer.MAX_VALUE;
         
         
         while(right < n){
             
           sum += nums[right];   // add current element 
             
             if(sum >= target){   // if sum is greater than target
                 
                 while(sum >= target){    // keep shrinking window moving by left boundry untill sum < target
                     sum -= nums[left];
                     left++;
                 }
                 winLen = Math.min(winLen,(right-left+1)+1);  // left pointer inside skip first element so added extra 1
             }
           
             right++;
         
         }
         return winLen==Integer.MAX_VALUE ? 0: winLen;
      }
    
    
    /*public int minSubArrayLen(int target, int[] nums) {
        
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                
                if(sum >= target){
                   minLen = Math.min(j-i+1,minLen); 
                    break;
                }
                
            }
        }
        return minLen;
    }*/
}
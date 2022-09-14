class Solution {
    public int majorityElement(int[] nums) {
        
        /** intution for better solution 
          majority element is greater than n/2 time so
          
          if any array have 11 element , 8 starting elemnt have same number of majority and minority 
          then they cancellled with each other. so majority is decided in next 3 elemnt.
          
          moore's voting algo
        
        */
        
        int count=0;
        int candidate=0;
        
        for(int  num:nums){
            
            if(count == 0){
                candidate = num;
            }
            if(candidate == num){
                count++;
            }else{
                count--;
            }
        }
        
        return candidate;
    }
}
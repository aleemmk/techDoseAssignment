class Solution {
    
    /**
       0      1      2     3     4
      [2,     3,     1,    1,    4]
       x--------------X
               x------------------X
                      x-----X
                             x------X
      (currBegin,currEnd)
      
        currFarthest
        
        when i is reached to currEnd  when need to jump and our new currEnd is currFarthest.
        keep on doing untill end of array.
      
    */
    public int jump(int[] nums) {
        int currEnd= 0;
        int jump = 0;
        int currFarthest =0;
        int n = nums.length;
        
        for(int i=0;i< n-1;i++){
            
            currFarthest = Math.max(currFarthest,i+nums[i]);
            
            if(i == currEnd){
                jump++;
                currEnd  = currFarthest ;
            }
        }
        return jump;
    }
}
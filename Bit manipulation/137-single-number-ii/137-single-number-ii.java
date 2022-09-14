class Solution {
    public int singleNumber(int[] nums) {
        /**
          calcuate the sum of set bit at each position of 32 bit number add them called it sum.
        if sum%3 == 1 then this is our bit required for the single number. 
        */
        
        int res = 0;
        for(int i=0; i<32 ;i ++){
            int sum  = 0 ;
            for(int j=0; j<nums.length;j++){
                if((nums[j] & (1 << i)) != 0)
                    sum++;
                
            }
            
            if(sum % 3==1)
                res = res +(1<<i);
        }
        return res;
    }
}
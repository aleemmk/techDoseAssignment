class NumArray {
    
    /**
    The idea behind the approach is to maintian the prefix sum array .
     return sum , 
      sum from 2 to 5 (both inclusive)
     rangesum(2,5) = prefix [5] -prefix[2-1];
    */
   
    int prefix [] ;
    public NumArray(int[] nums) {
        
        if(nums.length != 0) 
            prefix = new int[nums.length];
        
        prefix[0] = nums[0];
        
        for(int i=1;i<=nums.length-1;i++){
            prefix[i] = prefix[i-1]+ nums[i];
        }
        
    }
    
    public int sumRange(int left, int right) {
        if(left ==0)
            return prefix[right];
          
        return  prefix[right] -prefix[left-1] ;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
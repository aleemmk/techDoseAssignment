class Solution {
    public int singleNumber(int[] nums) {
        
        // XOR of number to itself is 0  
        // 0 ^ n = n 
        int res = nums[0];
        for(int i=1;i <nums.length;i++){
            
            res = res ^ nums[i];
            
        }
        return res;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        /**
          The intution behind the solution is to use hashing .

         use to add in collection and before adding check if (trget - curr)
         is exist or not if exist [curr , (target-curr)] is solution.
         
         use Map to store index. 
        
        */
        
        Map<Integer,Integer> map = new HashMap<>();
        int res []= new int[2];
        
        for(int i=0;i<=nums.length-1;i++){
           
            if(map.containsKey(target-nums[i])){
                res[0]=i;
                res[1] = map.get(target-nums[i]);
                
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
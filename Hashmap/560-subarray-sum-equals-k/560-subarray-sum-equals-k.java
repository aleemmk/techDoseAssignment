class Solution {
    
    /**                  i      j 
     int nums [] = [3 4  7  2  -3  1   4 2  ]
     prefixSum []= [3 7  14 16 13  14 18 20 ]
     
     sum(i,j) = prefixSum(j)-prefixSum(i-1);
     i=0
     then 
     sum(i,j) = prefixSum(j)
     TC O(n2)
     
     use hash Map and prefix sum
     map(sum,count)
     if (prefixSum-k) is present as a key in hash map it means there must be any sub array 
     whose sum equal to k because prefix sum is left sum of array.
     
     
    */
    public int subarraySum(int[] nums, int k) {
      int count =0 ;
        int prefixSum =0;
      Map<Integer,Integer> map =new HashMap<>(); 
        
        map.put(0,1) ;   // making sum zero always be possible
        
        for(int i=0;i<nums.length;i++){
            
            prefixSum += nums[i];
            
            if(map.containsKey(prefixSum-k))
                count +=map.get(prefixSum-k);  // add in curr count ;
            
            if(map.containsKey(prefixSum)){
                map.put(prefixSum,map.get(prefixSum)+1);
            }else{
                map.put(prefixSum,1);
            }
          //  map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        
        return count;
    }
}
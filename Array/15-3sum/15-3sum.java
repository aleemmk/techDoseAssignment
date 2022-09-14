class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        /**
          The idea behind the solution is to first sort the array .
          need to fix each element one by one.
 
 
          [-1,0,1,2,-1,-4]  original array
          
           ij           k
          [-4,0,-1,-1,1,2]   after sorting
              ^
              |
          fix each element one by one and find two other value start from extreme ends so that all three is zero.
          if arr[j] == arr[j+1]  keep moving  j++;
          if arr[k] == arr[k-1]  keep moving  k--;
           case 1 : sum == 0  add in result
           case 2   sum < 0    j++ moving to right;
           case 3   sum > 0    find lower value moving to left k--;
        */
        
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        if(n<3) return res;
        
        Arrays.sort(nums);
        
        for(int i=0;i<n-2;i++){
            if(i==0 || nums[i] != nums[i-1]){
                
           int j= i+1; int k= n-1;
                
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    
                    while(j<k && nums[j] == nums[j+1]) j++;
                    
                    while(j<k && nums[k] ==nums[k-1]) k--;
                    
                    j++;
                    k--;
                    
                }else if(sum > 0) k--;
                else{
                    j++;
                }
             }
           }
      
         }
        
        return res;
    }
}
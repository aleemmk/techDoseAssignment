class Solution {
    
    /**
    method 1 : 
    ==============
       The idea behind the approach is to first sort the array .
       then tale three pointer 
       
        i=0 ,j=i+1 ,k=j+1 then 
        target2 = target - arr[i]-arr[j]-arr[k];
         search target2 in remaining array with binary search 
         
         time complexity = O(n log n + n^3 log n)
         ----------------
         space : use set to maintain unique  O(n)
         
         method 2 : 
         ===========
         sort the array use two pointer i=0 , j=i+1;
         left & right
        target2 = target - arr[i]-arr[j];
          
        move left,right such that target2 = arr[left] +arr[right];
        
        for maintaining uniqueness we need to jump on duplicates value 
        while moving i j left and right
        time complexity = n* n*n  = O(n^3)
        ---------------
        space  O(1)

          
       4 3 3 4 4 2 1 2 1 1
       1 1 1 2 2 3 3 4 4 4
       ^ ^ ^             ^
       | | |             |
       i j left          right
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
     
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length==0) return res;
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i=0 ; i<n;i++){
            for(int j=i+1;j<n;j++){
               long target2 = (long)target- (long)nums[i]-(long)nums[j];
                
                int left= j+1;
                int right = n-1;
                while(left<right){
                    long twoSum = (long)nums[left] + (long)nums[right] ;
                    if(twoSum< target2){
                        left++;
                    }else if(twoSum > target2){
                        right--;
                    }else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        
                        res.add(quad);
                    
                    // jump on duplicates
                     while(left < right && nums[left] == quad.get(2)) left++;
                     while(left < right && nums[right] == quad.get(3)) right--;
                    }
                }
                
                while(j+1 < n && nums[j+1] == nums[j] ) j++;
            }
            while(i+1 < n && nums[i+1] == nums[i]) i++;
        }
            
            return res;
    }
}
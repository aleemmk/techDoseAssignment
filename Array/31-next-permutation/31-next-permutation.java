class Solution {
    
    /**
      3 2 1 4 5
      next permutation : 3 2 1 5 4
      
      3 2 1 4 5 6
      next permutation : 3 2 1 4 6 5
      
       2,3,6,5,4,1
      next permutation : 2 4 1 3 5 6
              6
                5
                  4
               
          3
        2            
                      1
        4 > 1 correct
        5 > 4  correct
        6 > 5 correct
        3 > 6  not correct
        
        pick 3 and find a element from right most which is greater than 3 here is 4, swap
        
        2 4 6 5 3 1 after 4 everything is decending order (max element of 24 series)
        
        we want minmum in 24 series for next permutaion
        
        get min by reversing after 4
        
        2 4 1 3 5 6   our answer 
        
        case 2:
        if not get any number such that arr[k+1] > arr[k] 5 4 3 2 1
        mean it is last permutaion so reverse number to get first permustation according to question.
        
        pseudo code :
        1.we find largest index k such that arr[k+1] > arr[k] if not then reverse
        2. we find largest index l (l > k) and arr[l] > arr[k] swap both
        3. reverse subarray k+1 to n-1 in arr[];
    */
    public void nextPermutation(int[] nums) {
        int k;
        int n = nums.length;
        int l;
        if( n < 2)
          return;
        
        for(k=n-2;k>=0;k--){
            
            if(nums[k] < nums[k+1]){ //  from above example try to find incorrect 3 > 6  
                break;
            }
        }
        
        if(k < 0){
            reverse(nums,0,n-1);
            return;
        }else{
            for(l=n-1;l>=0;l--){
                if(nums[l] > nums[k]){
                    break;
                }
            }
        }
        swap(nums,k,l);
        reverse(nums,k+1,n-1);
    }
    
    void reverse(int[] nums, int s, int e){
      while(s < e){
        swap(nums, s++, e--);
      }
    }
    
    void swap(int[] nums, int s, int e){
         nums[s] =nums[s] ^ nums[e];
         nums[e] = nums[s] ^ nums[e];
         nums[s] = nums[s] ^ nums[e];    
    }
}
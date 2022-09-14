class Solution {
    public void sortColors(int[] nums) {
        
        /** The idea is to iterate array with two pointer at nums[0] 
         if we get 0 swap with extreme left and we get 2 push swap it with extreme right .
put one pointer at end of array .
if we get 1 just move on .

        */
     
          int i=0;
        int j=0;
        int k= nums.length-1;
        while(i <= k){
            if(nums[i] == 2){
                
                swap(nums,i,k);
                k--;
            }else if(nums[i] == 0){
                
                swap(nums,i,j);
                i++;
                j++;
            }else{
                i++;
            }
            
        }
    }
    
      public void swap(int [] arr , int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}
class Solution {
    public int[] sortArray(int[] nums) {
        
        /**
        The idea behind merge sort is to dive the array in to two equal half and they combine and they are   combned in a sorted manner. it is a recusive algorithm that continuously dived into two equal half untill it can not be further divide . either have one or empty element.(base condition of recursion) 
DIVIDE AND CONQUER . 
        */
        int n = nums.length;
        
        mergeSort(nums,0,n-1);
        
        return nums;
    }
    
    private void mergeSort(int[] nums ,int start,int end){
        
        if(end-start+1 <=1 ) return ;
        
        int mid = start+(end-start)/2;
        
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        
        merge(nums,start,mid,end);
    }
    
    /** now we have two arrays one is from start to mid and another is from mid to end 
     so merge this two array.
     */
    private void merge(int [] nums, int start,int mid,int end){
         
        int [] res = new int[end-start+1];
        
        int arr1Start = start;
        
        int arr2Start = mid+1;
        
        int k=0;
        while(arr1Start <= mid && arr2Start <=end){
              
            if(nums[arr1Start] < nums[arr2Start]){
               res[k] = nums[arr1Start];
               arr1Start++;
               k++;
            }else{
                res[k] = nums[arr2Start];
               arr2Start++;
               k++;
            }
        }
        
        while(arr1Start <= mid){
            res[k] = nums[arr1Start];
               arr1Start++;
               k++;
        }
        
        while(arr2Start <=end){
             res[k] = nums[arr2Start];
               arr2Start++;
               k++;
        }
      
         /**
           nums [] = [4,5,9,7,10,8,13,]
                        ^      ^
                        |      |
                      start   end
                      
           res [] =[5,9,7,10]
                      
                      
         */
        for(int i=start ; i<=end;i++)  nums[i] = res[i-start];
        
    }
}
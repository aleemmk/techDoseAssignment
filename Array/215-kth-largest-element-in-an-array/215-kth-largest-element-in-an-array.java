class Solution {
    
    /**
      we can use min heap of size k 
      
      if size > k  remove top element of heap 
      atlast we have only k element in heap return top element 
     TC
     
     n logk
    */
     public int findKthLargest1(int[] nums, int k) {
         
         PriorityQueue<Integer> minheap = new PriorityQueue<>();  // minheap
         
         for(int num:nums){
             
             minheap.offer(num);
             if(minheap.size() > k) minheap.poll();
             
             
         }
         return minheap.poll();
     }
    
      /**
         Kth largest means  n-k+1 smallest .
         
         n= 6
         
         arr [1,2,3,4,5,6]    k = 3 largest.  // 4
         

         intution is to to select pivot and find the index of pivot element as per partition of
         quick sort , 
         
         TC O(n)  in best time 
         we we reshufffle array before quick select it will always guarantted O(n)
         
        */
    
    private int [] shuffle(int arr[]){
        Random rand = new Random();
        for(int j=1;j<arr.length;j++){
            int i = rand.nextInt(j+1);   // produce a number between 0 to j (0 inclusive anf j exclusive)
            swap(i,j,arr);
        }
        return arr;
    }
    
    public int findKthLargest(int[] nums, int k) {
      
        int n = nums.length;
        int left = 0 ;
        int right = n-1;
        //  here we need to pass k-1 for k th smallest so (n-k+1)-1 = n-k 
        
       return  quickSelect(shuffle(nums),n-k,0,right);
        
    }
    
    private int quickSelect(int [] nums ,int k ,int left,int right){

         int pivot = nums[right];
         int pi = partition(nums,left,right,pivot);

         if(k > pi ){
            return  quickSelect(nums,k,pi+1,right);
         }else if(k < pi){
             return quickSelect(nums,k,left,pi-1);
         }else{
             return nums[pi];
         }
    }
    
    private int partition(int [] nums ,int left,int right, int pivot){
        int i=left;
        int j=left;

        while(i <= right){
            if(nums[i] <= pivot){
                swap(i,j,nums);   // swap with i and j so increase both pointer i++ ,j ++
                i++;   
                j++;
            }else{
                i++;
            }
        }
        return j-1;
  }
    
    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
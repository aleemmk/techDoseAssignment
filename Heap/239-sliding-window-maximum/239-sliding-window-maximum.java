class Solution {
    /**
     first intutive solution is to travese all subarray of window size k find tha max in each window and put into  resultant array .
     
     TC
     
     outer loop n
        inner loop of widow size
        
        O(nk)
        
     2. Approach
      we can use double ended queue .
      
      TC  o(n)+o(n) amortized
      space O(K);
     
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int result [] = new int[n-k+1];
        int resIndex=0;
        
        Deque<Integer> dq = new LinkedList<>();
        
        for(int curr=0; curr<n ; curr++){
            
            // if current index is out of window remove first element from dq; 
            
            if(!dq.isEmpty() && (curr-k) == dq.peekFirst()){
                dq.pollFirst();   // poll or pollFirst is same 
            }
            // if nums[curr] is greater than last elemnt of dq ,we keep on removing untill we find greater         element than nums[curr]
            
             // remove smaller number in k range as they are useless
            
            while(!dq.isEmpty() && nums[curr] > nums[dq.peekLast()]){
                dq.pollLast();
            }
            
            dq.offerLast(curr);   // offer and offerLast is same for queue
            
            if(curr >= k-1)
                result[resIndex++] = nums[dq.peekFirst()]; 
            
        }
        return result;
    }
}
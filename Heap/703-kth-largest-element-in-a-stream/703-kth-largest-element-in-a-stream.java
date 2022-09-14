class KthLargest {
  /**
   use min heap of size k track last k hight element and peek in min heap is the answer.
   
   if min heap size is less than k then keep on adding.
   if the min heap size is greater than k and  curr element is higher than peek and remove peek and add then add only.
   
  */
     private int k;
     private Queue<Integer> pq ;
    
     public KthLargest(int k, int[] nums) {
        
        this.k = k;
        pq = new PriorityQueue<>(k);
         
         for(int num:nums){
             add(num);
         }
        
    }
    
    public int add(int num) {
        
        if(pq.size() < k){
            pq.offer(num);
        }else{
            if(pq.peek() < num){
                pq.poll();
                pq.offer(num);
            }
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
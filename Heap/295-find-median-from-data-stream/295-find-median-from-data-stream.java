class MedianFinder {
    
    /**
     meadian is the mid value in order elment :
     
     [3 1 2]  => order = [1,2,3] = median = 2
     [1,4,3,2]  => order = [1,2,3,4] = median = (2+3)/2 = 2
     
     1 : Approach
     we can maintain the order of stream , whenever new element added find the exact position of
     element by insertion sort .
     TC
     ===
     for each new element at most travel n element for finding postion .
     and for adding n element O(n*n) ;
     
     getting median O(1) 
     
     2. Approach 
     we focus on time complexity of maintaining order as we can't reduce n.
     
     question : is there any thing we can in below O(n)  ?
     
     if we use heap we can track max and min element here we need to track middle element.
     
     we can divide arry into two heap , 
     odd
     [x1,x2,x3,x4,x5]
     MAX- HEAP [x1,x2,x3] , min heap[x4,x5];
     meadian is top of max heap
     
     EVEN
     [x1,x2,x3,x4,x5,x6]
     MAX- HEAP [x1,x2,x3] , min heap[x4,x5,x6];
     meadian is (top of max heap+top of min heap)/2
     
     we assume max heap is always greater than 1 in case of odd .
     
     
    1.if max heap is empty or num <= maxheap top 
       insert into max heap
       else insert into min heap
       
       keep checking for size so that max heap is always greater than 1 in case of odd 
       
       if(maxheap_size > minheap_size+ 1)
         pop from max heap and push into min heap
         if(maxheap_size < minheap_size)
         pop from min heap and push into max heap
    
    2.  median 
      maxheap_size = minheap_size
      then top(maxheap)+top(minheap) /2
      
      else top max heap;
    
    
     */
    
    Queue<Integer> minheap = null;
     Queue<Integer> maxheap = null;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        /** by deafult add to the left for adding in right it must contains element 
        and num >= top of right
         maxheap | minheap
         left    | right
        */
        
        if(!minheap.isEmpty() && num >= minheap.peek()){
             minheap.offer(num);
        }else{
             maxheap.offer(num);
        }
                       
        if(maxheap.size() > minheap.size() + 1)
             minheap.offer(maxheap.poll());
            
            if(maxheap.size() < minheap.size())
                maxheap.offer(minheap.poll());
        
    }
    
    public double findMedian() {
        if(maxheap.size() == minheap.size())
            return maxheap.peek()/2.0 + minheap.peek()/2.0 ;
        
        return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
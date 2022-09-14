class Solution {
    
    /**
      idea behind the solution is to use hash mao as a frequecy map.
      
      we need only top k frequent element , we can use min heap 
      add Entries into min heap as we need only k 
       if size is greater than k pop top element , and it maintain size k size min heap 
       
    */
    public int[] topKFrequent(int[] nums, int k) {
        
        
        Map<Integer ,Integer> map = new HashMap<>();
        
        for(int num:nums){
            
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        // pass comparator in pq 
         PriorityQueue<Map.Entry<Integer, Integer>> minheap =
            new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
       
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            
            minheap.add(entry);
            
            if(minheap.size() > k) minheap.poll();
        }
        
        int res [] = new int[k];
         int i=0;
         while(i < k){
             res[i++] = minheap.poll().getKey();
         }
        
        return res;
    }
}
class Solution {
    
    /**
     indea behinf the solution is the make a frequency map ,
     
     put all entries in a maxheap ,
      
      TC
      ======
     if it contains m distinct character
     pop from heap O(logm)
     O(n)+ O(m log m)
     
     we have only 26 alphabet at most heap size is 26 almost negligible as compare to n
     
      approx : O(n);
    */
    public String frequencySort(String s) {
        
     char arr[] = s.toCharArray();
        
        Map<Character,Integer> map = new HashMap<>();
        for(char c:arr){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        Queue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        
    for(Map.Entry<Character,Integer> entry:map.entrySet()){
        
        pq.offer(entry);
    }
        
        StringBuilder sb = new StringBuilder();
        
        
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            
            int freq = entry.getValue();
            
            for(int i=0; i<freq;i++){
                sb.append(entry.getKey());
            }
            
        }
        return sb.toString();
    }
}
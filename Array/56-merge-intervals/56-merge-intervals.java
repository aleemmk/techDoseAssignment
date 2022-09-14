class Solution {
    public int[][] merge(int[][] intervals) {
       
        /**
         The idea is to sort the intervals by starting points . 
         and comapre with its end with the next interval. if they overlapped 
         we need to take maximum of overlapping intervals.
         
         complexity sorting = O(n long n) + O(n)  (merging)
            curr_end
         a-------------b
                    c---------d 
                                  e-------f
          a = curr_begin 
          b= curr_end
          c= next_begin
          d= next_end
                                  
            b > c is overlapped   merged
            else add to answer
        */
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] o1,int [] o2){
                return Integer.compare(o1[0],o2[0]);
            }
        });
        
        List<int[]> res = new ArrayList<>();
        int [] curr_interval = intervals[0];
        
        res.add(curr_interval);
        
        for(int[] interval:intervals){
            int curr_begin = curr_interval[0];
            int curr_end = curr_interval[1];
            
            int next_begin = interval[0];
            int next_end = interval[1];
            
            if(curr_end >=next_begin){
                // overlapped
                curr_interval [1] = Math.max(curr_end,next_end);
            }else{
                // not over lapped;
                curr_interval = interval;
                
                res.add(curr_interval);
             
            }
            
        }
       return res.toArray(new int[res.size()][]);
    }
}
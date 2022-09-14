class Solution {
    
    /**
    
    Greedy Approach
    
     index  0      1     2    3    4     5    6
     Ranges 3      4     1    1    2     0    0
            x-----------------x 
                   x----------------------x
                   x-----------x
                          x---------x
                          x---------------------x 
                                          x
                                          
                                          
     
    -3         3    [i-ranges[i]]    [i+ranges[i]]
    -3         5
     1         3
     2         4
     2         6
     5         5
     
     open the tab which start with <=0 and have max range
     min = 0 ,max =5
     (-3 5) 
     open the tab which start with <=5 and have max range
     (2,6)
     
     keep on doing  till max < n
     answer is 2 here
     
     optimization :
     once got one max range then we can search after that index of max.
    */
    public int minTaps(int n, int[] ranges) {
        
        int min=0;
        int max=0;
        int index =0;
        int openTab = 0;
        
        while(max < n){
            
            for(int i=index;i<ranges.length;i++){
                
                if( i-ranges[i] <= min && i+ranges[i] > max){
                    max = i+ranges[i];
                    index = i;
                }
            }
            if(min == max) return -1;   // garden can not watered [0 0 0 0] no max found .
            
            openTab++;
           
            min = max;       
        }
        
        return openTab;
    }
                    
   
}
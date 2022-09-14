class Solution {
    
    /**
     most intutive solution make BFS on grid 
     
     count all fresh oranges , push all rotten oranges in a queue and mark adjacent oranges rotten as below
     
                   (x,y-1)
                     ^ 
          (x-1,y) <- | - > (x+1,y)
                     v
                  (x,y+1)
       
       reduce fresh oranges and add newly marked rotten oranges in queue . 
       
       keeep on doing this utill fresh oranges become zero or queue is empty.
       
       if fresh oranges still remain when queue exhausted return -1;
       
       so number of times outer loop runs to make queuue 
       empty is same as number of min return this as answer.
    */
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int []> queue = new LinkedList<>();
        
        int countfresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1) countfresh++;
                else if(grid[i][j] == 2){
                    int [] rotLocation = {i,j};
                    queue.offer(rotLocation);
                }
            }
        }
        
        if(countfresh == 0) return 0;  // fresh is zero 
        
        int dirs[][] = {{-1,0},{0,1},{0,-1},{1,0}};
        
        int count=0;
        
        // either queue or fresh oranges which one is exhausted earlier.
     while(!queue.isEmpty() && countfresh > 0){  
        
         int size = queue.size();
         
         for(int i=0;i<size;i++){
             int point[] = queue.poll();
        
             // check all direction of current point including boundry if not rotton , rot it
             
             for(int[] dir:dirs){
                 int x = point[0]+dir[0];
                 int y = point[1]+dir[1];
                 
                 if(x < 0 || y<0 || x>=rows || y>=cols || grid[x][y] ==0 || grid[x][y] == 2) continue;
                 
                 grid[x][y] =2;
                 
                 countfresh -- ;
                 int p [] = {x,y};
                 queue.add(p);
             }
             
         }
          count++;
     }
    
        
         return countfresh != 0 ? -1: count;
    }
}
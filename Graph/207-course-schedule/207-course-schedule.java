class Solution {
    /**
      we detect the cycle in graph by graph coloring.
      
      we take three status 
      
      0  unvisited
      1  processing
      2  processed.
      
       do DFS in graph and if all vertex is processed then it does not have cycle else have cycle.
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i< numCourses ;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        /*for(int[] preq:prerequisites){
            List<Integer> list = adj.get(preq[0]);
            list.add(preq[1]);
        }*/
        
        int visited [] = new int[numCourses];
        
        Arrays.fill(visited,0);    // make 0 means unvisited
        
        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0)
               if(isCycle(adj,visited,i)) return false;    // if cycle is detected  false
        }
        return true;  
    }
    
    private boolean isCycle(List<List<Integer>>adj,int [] visited,int curr){
     
        if(visited[curr] == 2) return true;         // already processed
        
           visited[curr] = 2;   // make this node processed
        
        for(int adjEle:adj.get(curr)){
            if(visited[adjEle] != 1){
                if(isCycle(adj,visited,adjEle)) return true; 
            }
        }
        visited[curr] = 1;     // make node  processing 
        
        return false;
    }
}
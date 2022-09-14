class Solution {
    
    /**
    
    A Bipartite graph can only have even length cycle.
     
     Here we chose solution of graph coloring we chose two color (red, green) if a node is red then all it's adjacent    nodes are green . if we find ambiguity in this then it means the graph have odd length cycle and hence not bipartite.
     
      state 

     Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
     
     input is given as adjacency list 0 index have adjacent node {1,2,3}
     
      TC 
      O(V)  V for coloring.
    */
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        
        int color[] = new int[n+1];
        
        Arrays.fill(color,-1);
        
        for(int i=0 ;i < graph.length;i++){
            
            // visit only if not colored yet 0 or 1;
            if(color[i] == -1 )
                if( !bfs(graph,color,i)) return false;
        }
        return true;
        
    }
    
    private boolean bfs(int[][] graph , int color[],int curr){
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(curr);
        color[curr] = 1 ; // color is 1 or 0
            
            while(!q.isEmpty()){
                int node = q.poll();
                
                for(int neighnour:graph[node]){
                    // color of node and any of it's adjacent node are not same
                    
                    if(color[node] == color[neighnour])  return false; 
                    
                    // visit only if not colored yet not 0 or 1
                    if(color[neighnour] == -1){
                        color[neighnour] = 1-color[node];
                        q.add(neighnour);
                    }
                }
            }
            return true;
    }
}
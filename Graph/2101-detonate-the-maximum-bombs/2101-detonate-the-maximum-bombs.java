class Solution {
    
    /**
     bombs have b0 (x0,y0,r0) and c(x1,y1,r1)
     
     bomb b can detoniate c only when (x1-x0)^2 + (y1-y0) ^ 2 <= r0^2 
     
     first we need to check for every bomb i collect all bomb j that in range in adjacency list.
     
     this will convet into graph 
      
     DO DFS in graph from each node and find the longest chain of bombs that detoniated ie. max number of node in recusive stack.
    */
    public int maximumDetonation(int[][] bombs) {
        
        List<List<Integer>> adj = new ArrayList<>();
          int n = bombs.length;
        for(int i=0 ;i<n;i++){
            adj.add(new ArrayList());
        }
      
        
        boolean [] vis = new boolean[n];
        
        int max = 1;
        
        Arrays.fill(vis,false);
       
        for(int i=0;i<n;i++){
            
            long x0 = bombs[i][0];
            long y0 = bombs[i][1];
            long r0 = bombs[i][2];
            
            for(int j=0;j<n;j++){
                 long x1 = bombs[j][0];
                 long y1 = bombs[j][1];
                 long r1 = bombs[j][2];
                
                if(i!=j){
                     if(((x0-x1)*(x0-x1)+(y0-y1)*(y0-y1))<=r0*r0)
                         adj.get(i).add(j);
                }
            }
        }
        
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int ans = dfs(i,adj,vis);
                Arrays.fill(vis,false);
                 max = Math.max(ans,max);
            }
                
        }
        return max;
    }
    
    private int dfs(int i,List<List<Integer>> adj,boolean []vis){
        vis[i] =true;
        int ans = 1;
        
      
        for(int node:adj.get(i)){
            if(!vis[node])
                ans += dfs(node,adj,vis);
                
        }
        return ans;
    }
}
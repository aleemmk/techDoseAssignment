class Solution {
    /** */
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        
       // List<int []> adj = new ArrayList<>();
        
          ArrayList<int[]>  adj [] = new ArrayList[n];
        
        for(int i=0 ; i< n ;i++){
            adj [i] = new ArrayList<>();
        }
        
    for(int i=0;i < n ;i++){
        
        for(int j=i+1;j<n;j++){
              
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            int x2 = points[j][0];
            int y2 = points[j][1];
            
            int d = Math.abs(x1-x2)+ Math.abs(y1-y2);
            
            adj[i].add(new int[]{j,d});
            adj[j].add(new int[]{i,d});
        }
    }
        
       Queue<int[]> pq  = new PriorityQueue<>((a,b)-> a[1]-b[1] );
        int wtSum = 0;
        
        
        HashSet<Integer> visited = new HashSet<>();
        
        
        pq.offer(new int[]{0,0});
        
        
        while(visited.size() < n){
            
            int curr [] = pq.poll();
            
            int v =  curr[0];
            int wt = curr[1];
            
            if(visited.contains(v)) continue;
                visited.add(v);
            
                wtSum += wt;
            
            
            for(int[]  node:adj[v] ){
                if(!visited.contains(node[0])) 
                    pq.add(node);
                
            }
        }
        
        return wtSum;
            
    }
}
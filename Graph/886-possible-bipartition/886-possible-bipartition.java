class Solution {
    
    /**
    [[1,2],[1,3],[2,4]]
    
    first intutive solution is to choose two sets (A ,B) and put the people into sets and before putting , check in which set it is present .
    A     B
    1     2
    4     3       
    
    another approach is bipartite graph , a bipartitile graph is graph that can be divided into two disjoint and 
    independent set (u,v) such thet every edge connect to vertex in u to a vertex in V.
    
    [1,2] [2,3] [2,4] [3,5] [4,5]
    
    1 -----2
    3------5
    4
    u      V
    
    here no edge between vetices in same set suppose if we inset [1,4] then in set u edge between 1,4 so it will not 
    bipartite.
    
    IMPORTANT : a bipartite graph can only have even edge length cycle.
    so if the graph does not have odd vertices length cycle then yes we can divide the people into two sets.
    
      Better solution is grap coloring to detect odd length cycle
      we choose two color (red ,green) and if the color of a vertex is red then 
      its adjacent vertices have green . if there is any ambiguity in graph coloring then it is odd length cycle
      
      we can do coloring with either DFS/BFS
      
      TC 
      O(E + V) E for making adjacency list and V for coloring.
    */
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i< n+1;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] dislike:dislikes){
            adj.get(dislike[0]).add(dislike[1]);
            adj.get(dislike[1]).add(dislike[0]);
          }
        
        int color [] = new int[n+1];
          Arrays.fill(color,-1);
        
        for(int i=1;i<=n;i++){
            if(color[i] == -1)
                if(!isBipartite(adj,n,color,i)) return false;
        }
        return true;
    }
    
    private boolean isBipartite(List<List<Integer>> adj,int n, int color [] ,int i){
        
        Queue<Integer> que = new LinkedList<>();
        // chosen color is 1 or 0
        que.offer(i);
        color[i] = 1;
        
        while(!que.isEmpty()){
            int curr = que.poll();
              
          for(int ele:adj.get(curr)){
              if(color[ele] == color[curr]) return false;
              
              if(color[ele] == -1){
                  color[ele] = 1-color[curr];
                  que.offer(ele);
              }
          }
        }
        return true;
    }
}
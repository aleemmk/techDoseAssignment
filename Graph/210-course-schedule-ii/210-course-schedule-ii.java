class Solution {
    /**
     Topological sort is only possible in DAG( directed acyclic graph ) 
     
    (1,3) (1,2) (2,4)(3,4) is a DAG
    
    (1,2) (2,4)(4,3)(3,1) not a DAG .
    
    topological sort is a linear ordering of vertices in DAG such that for every directed edge uv(u->v)
    vertex u always comes before v. in the ordering.
    
    topological sort will start with the node have indegree equal to 0.
    
    APPRoach :
    
    DFS + Stack = recursion + visted array +stack
    
    start DFS when we reach a vertex when no ougoing edge is left to traverse, backtack and push into stack .
    
    when every vertex is traversed ,just pop from stack and return the result.
    
    in case of cycle return a empty array. (detech cycle by graph coloring)
    
    TC 
    O(V+E)
     
    */
    
    
    /**
     Technic 2:
     
      kahn's algo
      
     BFS 
     
     1. filling indegree array
     
     2. filling queue ( push all node whose indgree is 0 in queue. we start topological sort from node whose indegree is 0               and keep on doing)
     
     3. processing queue. (removing curr node from graph it means indegree of adjacent node is decreasing if it is zero add int to the queue)
     
     when curr node processed add in ans list and increaed the processed node count.
     
     and finally
     if(processed node count != total node) means cycle.
     
    
    */
    
    
    
    /**BFS kahn' algo start */
     public int[] findOrder(int numCourses, int[][] prerequisites) {
          List<List<Integer>> adj = new ArrayList<>();
         
          for(int i=0;i< numCourses ;i++) adj.add(new ArrayList<>());
        
         
         int indegree[] = new int[numCourses];
         
         
         for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]  +=1;     // fill indegree array  STEP 1
        }
         
         int[] res = new int[numCourses];
         int emptyArr [] = {};
         
         if(kahnsAlgo(adj,numCourses,indegree,res)) return res;     // if kahan's alogo success 
         
         return emptyArr;   // return empty arr if not found
         
     }
    
    private boolean kahnsAlgo(List<List<Integer>> adj ,int numCourses, int indegree [],int [] res){
        
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        int index=0;
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0)
                q.add(i);                       // fill queue with indegree 0   STEP 2
                
        }
        
        while(!q.isEmpty()){
            
            int curr = q.poll();                     // process curr node
            
            for(int neighbour:adj.get(curr)){
                
                indegree[neighbour] -=1;                  // decrease all negibours indegree
                if(indegree[neighbour] == 0)              // during decrement if it is 0 add to queue
                    q.offer(neighbour);
            }
            
            res[index++] =curr;                          // add curr into ans when it is processed
            count +=1 ;                                  // processed node count
        }
        
        if(count != numCourses) return false;         // finally procced node count not equal to total vertices means cycle
        
        return true;
        
    }
    
     /**BFS kahn' algo end */
    
    
    
    private boolean isCycle(List<List<Integer>> adj  ,int numCourses){
         int visited [] = new int[numCourses];
        
        Arrays.fill(visited,0);    // make 0 means unvisited
        
        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0)
               if(isCycleUtil(adj,visited,i)) return true;    // if cycle is detected  false
        }
        return false;
    }
    
     private boolean isCycleUtil(List<List<Integer>>adj,int [] visited,int curr){
     
        if(visited[curr] == 2) return true;         // already processed
        
           visited[curr] = 2;   // make this node processed
        
        for(int adjEle:adj.get(curr)){
            if(visited[adjEle] != 1){
                if(isCycleUtil(adj,visited,adjEle)) return true; 
            }
        }
        visited[curr] = 1;     // make node  processing 
        
        return false;
    }
    
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int res []  = new int[numCourses];
        
        
        for(int i=0 ;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
         for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        /*for(int[] pre:prerequisites){
            List<Integer> list = adj.get(pre[1]);
            list.add(pre[0]);
        }*/
        
        // if cycle is detect return empty array.
        int [] emptyArr = {};
        if(isCycle(adj,numCourses)) return emptyArr;
        
        // find topological sort and store it in stack;
        
        Stack<Integer> myStack = new Stack();
        
        boolean visited []  = new boolean[numCourses];
        
        // Apply topological sort with DFS
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
               dfs(i,adj,visited,myStack);
        }
        int index =0;
        for(int i=0;i<numCourses;i++){
            res[i] = myStack.pop();
        }
       return res;
    }
    
    private void dfs(int i, List<List<Integer>> adj,boolean visited [] , Stack<Integer> myStack){
        
        visited[i] = true;
        
        for(Integer  neighbour:adj.get(i)){
            if(!visited[neighbour])
                dfs(neighbour,adj,visited,myStack);
        }
        
        myStack.push(i);
    }
}
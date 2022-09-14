/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/**
   
   we DFS on graph to start traverse with the given node . 
   we make the copy of given node first with the given val of the given node.
   
   but by this we ended up making same node twice so we need to ensure we make only one copy of node.
   to ensure this we use hashMap as current node as key and it's copy as a value.
   
   
   (2,4)        (1,3)
    1           2
    
    (1,3)      (2,4)
    4           3
    
    start witth 1 and (2,4) are adjust copy node 1 as 1' put in   map | 1 , 1'|
                                                                      ---------
    for all adjacent of 1 (2,4) create 2' and 4' and make 1' adjacents (2',4')  put in map | 1,1' |
                                                                                           | 2,2'|
                                                                                           | 3,3'|
                                                                                           -------
                          we do this recusively and return 1' .                                                                 
                                                                                           
 */
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        
        return cloneGraphUtils(node,map);
    }
    
    private Node cloneGraphUtils(Node node, Map<Node , Node> map){
        
        if(node == null) return null;
        
        Node copy = new Node(node.val);
        
        map.put(node ,copy);  // ensure to make copy node only once so two copy of same node is not creted.
        
        for(Node neighbourNode:node.neighbors){
            
            if(!map.containsKey(neighbourNode)){
                 // cloneGraphUtils(neighbourNode,map);
                 copy.neighbors.add(cloneGraphUtils(neighbourNode,map));
            }else{
                copy.neighbors.add(map.get(neighbourNode));
            }
        }
        
        return copy;
        
    }
}
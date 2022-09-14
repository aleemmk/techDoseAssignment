/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<TreeNode, TreeNode> map;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
         map = new HashMap<>();
         findParent(root,null);
        
        Queue<TreeNode> queue = new LinkedList<>();
         Set<TreeNode> visited = new HashSet<>();
        
        queue.add(target);
        visited.add(target);
        
        int dist = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            if(dist == k){
                
                for(TreeNode node:queue)
                    res.add(node.val);
                
                return res;
            }
            
            
            for(int i=1 ; i<=size;i++){
               TreeNode temp = queue.poll();
                
                if(null != temp.left && !visited.contains(temp.left)){
                    queue.add(temp.left);
                    visited.add(temp.left);
                }
                 if(null != temp.right && !visited.contains(temp.right)){
                    queue.add(temp.right);
                    visited.add(temp.right);
                }
                
                if(map.get(temp) != null && !visited.contains(map.get(temp))){
                    queue.add(map.get(temp));
                    visited.add(map.get(temp));
                }
                
            }
            dist++;
            
        }
        
        return res;
        
    }
    
    private void findParent(TreeNode root,TreeNode parent){
        
        if(root == null)
            return;
        
        map.put(root,parent);
       
        findParent(root.left,root);
        findParent(root.right,root);
    }
}
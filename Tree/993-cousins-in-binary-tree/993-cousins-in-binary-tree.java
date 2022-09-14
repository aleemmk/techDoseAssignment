/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        
        boolean xFound = false;
        boolean yFound = false;
        
        Queue<TreeNode>  queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size;i++){
                
                TreeNode curr = queue.poll();
                
                if(curr.left !=null && curr.right != null){
                    
                    if(curr.left.val == x && curr.right.val == y ||
                      curr.left.val == y && curr.right.val == x)
                        return false;
                }
                
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                
                if(curr.left !=null) queue.add(curr.left);
                    
                if(curr.right != null) queue.add(curr.right);
                    
            }
            if(xFound && yFound) return true;
            
            if(xFound && !yFound  || !xFound && yFound) return false;
            
         }
        
        
        return false;
    
        
    }
}
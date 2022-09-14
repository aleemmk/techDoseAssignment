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
    /*public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null || root.left == null && root.right == null)
            return true;
         
            if(root.left == null || root.right == null)
                return false;
    
           q.add(root.left);
           q.add(root.right);
          
          while(!q.isEmpty()){
          TreeNode left =  q.poll();
              TreeNode right = q.poll();
              
              if(left.left != null && right.right == null || left.left == null && right.right != null)
                  return false;
              if(left.right !=null && right.left == null || left.right ==null && right.left != null)
                  return false;
              if( left.left != null && right.right != null && left.left.val != right.right.val)
                  return false;
              if(left.right !=null && right.left !=null && left.right.val !=right.left.val)
                  return false;
              
              if(left.left != null )
                  q.add(left.left);
              if(right.right != null)
                  q.add(right.right);
              if(left.right != null)
                  q.add(left.right);
              if(right.left != null)
                 q.add(right.left);
              
          }
        return true;
        }*/
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root,root);
    }
    boolean isSymmetricUtil(TreeNode t1 , TreeNode t2){
        if(t1 == null && t2 == null)return true;
        if(t1 == null || t2 == null) return false;
        
        return t1.val == t2.val && isSymmetricUtil(t1.left,t2.right) 
            && isSymmetricUtil(t1.right ,t2.left);
    }
}
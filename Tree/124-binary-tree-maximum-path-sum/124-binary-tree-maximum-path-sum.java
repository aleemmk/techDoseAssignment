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
   
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
         
        maxPathSumHelper(root);
        
        return result;
    }
    
    public int maxPathSumHelper(TreeNode root){
        if(root== null) return 0;
        
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
    
        int ms = Math.max(Math.max(left,right)+root.val,root.val);
        int m21 = Math.max(ms,left+right+root.val);
        
        result =Math.max(result,m21);
        
        return ms;
    }
}
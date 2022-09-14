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
    public TreeNode bstFromPreorder(int[] preorder) {
        
    return constructBST(preorder,0,preorder.length-1);
        
    }
    
    TreeNode constructBST(int [] preorder,int l ,int r){
        
        if(l > r) return null;
        
        TreeNode root = new TreeNode(preorder[l]);
        
        if(l==r)
            return root;
        
        int idx = l+1;
        
        while(idx <= r && preorder[l] > preorder[idx]){
            idx++;
        }
        
        root.left = constructBST(preorder,l+1,idx-1);
        root.right =constructBST(preorder,idx,r);
        
        return root;
        
    }
    
}
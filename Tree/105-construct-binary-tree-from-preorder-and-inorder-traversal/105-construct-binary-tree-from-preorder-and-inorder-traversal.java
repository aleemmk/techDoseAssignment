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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || preorder == null || inorder.length != preorder.length) 
            return null;
        
        int n = inorder.length;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<n;i++){
           map.put(inorder[i],i);    
        }
        
       return  buildBT(inorder,0,n-1,preorder,0,map);
    }
    
    private TreeNode buildBT(int[] inorder,int i1,int i2, int[] preorder, int p1 ,Map<Integer,Integer> map){
        
       if(i1 > i2 || p1 > preorder.length-1) return null; 
       
       TreeNode root = new TreeNode(preorder[p1]);
       
       int idx = map.get(preorder[p1]);
       
       int diff = idx-i1;
       
       root.left = buildBT(inorder, i1, idx-1,preorder,p1+1,map);
       root.right = buildBT(inorder,idx+1,i2,preorder,p1+diff+1,map);
        
       return root;
        
    }
}
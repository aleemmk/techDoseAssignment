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
    public List<List<Integer>> levelOrder(TreeNode root) {
    
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new ArrayList<>();
        
        if(root == null)
            return wrapList;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
           int level = queue.size();
           
            for(int i=0;i<level;i++){
            TreeNode temp = queue.poll();
            if(temp.left != null)queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
                
                subList.add(temp.val);
            }
            wrapList.add(subList);
            
        }
        return wrapList;
    }
}
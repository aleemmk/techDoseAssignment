/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    
    private static final String STAR = "*"; 
    private static final String DELIMITER = ","; 
    
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preorderSerialize(root,sb);  
        
        return sb.toString();
    }
    
    private void preorderSerialize(TreeNode root , StringBuffer sb){
        
        if(root == null){
            sb.append(STAR).append(DELIMITER);
            return;
        }
        sb.append(root.val).append(DELIMITER);
        preorderSerialize(root.left , sb);
        preorderSerialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(DELIMITER);
        return preorderDeserialize(arr);
    }
    
    int index = 0;
    private TreeNode preorderDeserialize(String arr[]){
        if(index == arr.length-1) return null;
        
        String val= arr[index++] ;
        
         if(STAR.equals(val)) return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(val));
        
        root.left = preorderDeserialize(arr);
        root.right =  preorderDeserialize(arr);
        
        return root;
        
    
        }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
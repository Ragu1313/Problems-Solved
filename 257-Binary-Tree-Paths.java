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
    List<String> res = new ArrayList<>();
    
    public void dfs(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        
        // Append the current node's value to the path
        path += (path.isEmpty() ? \\ : \->\) + node.val;
        
        // If it's a leaf node, add the path to the result
        if (node.left == null && node.right == null) {
            res.add(path);
        } else {
            // Continue to traverse the left and right subtree
            dfs(node.left, path);
            dfs(node.right, path);
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            dfs(root, \\);
        }
        return res;
    }
}

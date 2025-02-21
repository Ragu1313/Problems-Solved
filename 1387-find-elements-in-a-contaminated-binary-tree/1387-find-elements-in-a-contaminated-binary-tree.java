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
class FindElements {
    Set<Integer> set = new HashSet<>();
    public void find(TreeNode root,int val){
        if(root==null) return ;
        set.add(val);
        root.val = val;
        find(root.left,val*2+1);
        find(root.right,val*2+2);
         
    }
    public FindElements(TreeNode root) {
        find(root,0);
    }
    
    public boolean find(int target) {
        if(set.contains(target))    return true;
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
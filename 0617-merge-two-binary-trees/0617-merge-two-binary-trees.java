
class Solution {
    public TreeNode merge(TreeNode node1,TreeNode node2){
        TreeNode node = null;
        int sum = -10000000;
        if(node1!=null){
            sum = 0;
            sum+=node1.val;
        }
        if(node2!=null){
            if(sum==-10000000)   sum=0;
            sum+=node2.val;
        }
        if(sum!=-10000000){
            node = new TreeNode(sum);
            if(node1!=null && node2!=null)
                node.left = merge(node1.left,node2.left);
            else if(node1==null && node2!=null){
                node.left = merge(node1,node2.left);
            }
            else 
                node.left = merge(node1.left,node2);

            if(node1!=null && node2!=null)
                node.right = merge(node1.right,node2.right);
            else if(node1==null && node2!=null){
                node.right = merge(node1,node2.right);
            }
            else 
                node.right = merge(node1.right,node2);
        }
    
        return node;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }
}
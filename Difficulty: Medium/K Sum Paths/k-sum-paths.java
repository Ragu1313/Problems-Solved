/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int res = 0;
    public void count(Node root,int k){
        if(root==null){
            return ;
        }
        
        helper(root,k,0);
        
        count(root.left,k);
        count(root.right,k);
        
    }
    
    public void helper(Node root,int k,int sum){
        if(root==null){
            return ;
        }
        if(sum+root.data==k)  {
            res++;
        }
        helper(root.left,k,sum+root.data);
        helper(root.right,k,sum+root.data);
        
    }
    
    public int countAllPaths(Node root, int k) {
        res = 0;
        count(root,k);
        return res;
    }
}
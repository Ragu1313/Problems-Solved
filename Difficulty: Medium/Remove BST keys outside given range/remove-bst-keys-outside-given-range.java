/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    Node remove(Node root,int l,int r){
        if(root==null )   return null;
        if(root.data<l)  return remove(root.right,l,r);
        if(root.data>r)  return remove(root.left,l,r);
        root.left = remove(root.left,l,r);
        root.right = remove(root.right,l,r);
        return root;
    }
    Node removekeys(Node root, int l, int r) {
        return remove(root,l,r);
    }
}
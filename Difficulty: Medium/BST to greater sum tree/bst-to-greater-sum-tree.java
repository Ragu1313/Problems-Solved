/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    public static int transform(Node root,int parent){
        if(root==null) {
            return 0;
        }
        int right = transform(root.right,parent);
        int temp = root.data;
        root.data = right + parent ;
        int left = transform(root.left, temp + root.data );
        return left + temp + right;
    }
    public static void transformTree(Node root) {
        transform(root,0);
    }
}
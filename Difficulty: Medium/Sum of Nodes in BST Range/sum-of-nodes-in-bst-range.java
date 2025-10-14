/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int arr[] = new int[1];
    public void sum(Node root,int l,int r){
       if(root!=null){
           if(root.data>=l && root.data<=r){
               arr[0] += root.data;
              
           }
            sum(root.left,l,r);
            sum(root.right,l,r);
       } 
    }
    public int nodeSum(Node root, int l, int r) {
        sum(root,l,r);
        return arr[0];
    }
}

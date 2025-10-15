/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int res[] = new int[1];
    public void kth(Node root , int arr[]){
        if(root!=null){
            kth(root.left,arr);
            arr[0]--;
            if(arr[0]==0){
                res[0] = root.data;
                return ;
            }
            kth(root.right,arr);
        }
    }
    public int kthSmallest(Node root, int k) {
        int arr[] = {k};
        res[0] = -1;
        kth(root,arr);
        
        return res[0];
    }
}
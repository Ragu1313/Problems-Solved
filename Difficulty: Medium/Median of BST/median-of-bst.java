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
    // int cnt = 0;
    public int  count(Node root){
        if(root==null){
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
    
    public boolean helper(Node root , int arr[],int cnt[]){
        if(root==null)  return false;
        
        if(helper(root.left,arr,cnt)){
            return true;
        }
        cnt[0]--;
        if(cnt[0]==0) {
            arr[0] = root.data;
            return true;
        }
        if(helper(root.right,arr,cnt)){
            return true;
        }
        return false;
    }
    
    public int findMedian(Node root) {
        int cnt[] = new int[1] ;
        cnt[0] = count(root);
        cnt[0] = (cnt[0] +1)/2;
        int arr[] = new int[1];
        helper(root,arr,cnt);
        return arr[0];
    }
}
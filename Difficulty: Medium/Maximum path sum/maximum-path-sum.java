/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    
    int find(Node root,int res[]){
        if(root!=null){
            int left = find(root.left , res);
            int right = find(root.right , res);
            int temp = left + right + root.data;
            res[0] = Math.max(res[0] , temp);
            res[0] = Math.max(res[0] , temp-left);
            res[0] = Math.max(res[0] , temp-right);
            return Math.max(0,root.data + Math.max(left,right));
        }
        return 0;
    }
    
    int findMaxSum(Node root) {
         int res[] = new int[1];
         res[0] = Integer.MIN_VALUE;
         find(root,res);
         return res[0];
    }
}
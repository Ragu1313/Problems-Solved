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
    public int find(int arr[],int ele,int n){
        for(int i=0;i<n;i++){
            if(arr[i]==ele) return i;
        }
        return -1;
    }
    public void swap(int arr[],int dup[],int i,int j){
        int temp = dup[i];
        dup[i] = arr[i];
        dup[j] = temp; 
    }
    public int minimumOperations(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int arr[] = new int[size];
            int dup[] = new int[size];
            int c = 0;
            while(size-->0){
                TreeNode temp = q.poll();
                arr[c++] = temp.val;
                if(temp.left!=null)
                    q.add(temp.left);
                
                if(temp.right!=null)
                    q.add(temp.right);
            }
            c = arr.length; 
            for(int i=0;i<c;i++){
                dup[i] = arr[i];
            }
            Arrays.sort(arr);
            for(int i=0;i<c;i++){
                if(dup[i]!=arr[i]){
                    res++;
                    int ind = find(dup,arr[i],c);
                    swap(arr,dup,i,ind);
                }
            }
            
        }
        return res;
    }
}
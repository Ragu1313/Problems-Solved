/*
103. Binary Tree Zigzag Level Order Traversal
Solved
Medium
Topics
Companies

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100


*/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> a = new ArrayList<>();
        if(root==null)
            return a;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0; 
        while(!q.isEmpty()){
            List<Integer> b = new ArrayList<>();
            int size = q.size();
            Stack<Integer> q1 = new Stack<>();
            while(size-- >0){
                if(count==0){
                    // count=1;
                    TreeNode temp = q.poll();
                    b.add(temp.val);
                    if(temp.left!=null)
                        q.add(temp.left);
                    if(temp.right!=null)
                        q.add(temp.right); 
                }
                else{
                    // count=0;
                    TreeNode temp = q.poll();
                    q1.add(temp.val);
                    if(temp.left!=null)
                        q.add(temp.left);
                    if(temp.right!=null)
                        q.add(temp.right);
                }
               
            }
            while(count==1 && q1.size()!=0){
                b.add(q1.pop());
            }
            count = count==0?1:0;
            a.add(b);
        }
        return a;
    }
}

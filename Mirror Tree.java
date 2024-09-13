/*
Mirror Tree
Difficulty: EasyAccuracy: 72.67%Submissions: 196K+Points: 2
Given a Binary Tree, convert it into its mirror.
MirrorTree1            

Examples:

Input:
      1
    /  \
   2    3
Output: 3 1 2
Explanation: The tree is
  1    (mirror)     1
 /  \    =>        /  \
2    3           3   2
The inorder of mirror is 3 1 2
Input:
      10
     /  \
    20   30
   /  \
  40  60
Output: 30 10 60 20 40
Explanation: The tree is
      10               10
    /    \  (mirror)    /    \
   20    30    =>   30    20
  /  \                     /   \
 40  60                 60   40
The inroder traversal of mirror is: 30 10 60 20 40.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the tree)

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 105
*/

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror1(Node node){
        if(node!=null){
            Node left = node.left;
            Node right = node.right;
            node.left = right;
            node.right = left;
            mirror1(node.left);
            mirror1(node.right);
        }
        return ;
    }
    void mirror(Node node) {
        // Your code here
        mirror1(node);
    }
}

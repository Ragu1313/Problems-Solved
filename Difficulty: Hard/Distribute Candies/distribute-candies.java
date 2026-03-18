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

    public int distCandy(Node root) {

    int[]moves={0};

  solve(root,moves);

  return moves[0];

        

    }

    int solve(Node root,int[]moves){

        if(root==null) return 0;

        int l=solve(root.left,moves);

        int r=solve(root.right,moves);

        moves[0]+=Math.abs(l)+Math.abs(r);

        return (l+r+root.data)-1;

    }

}
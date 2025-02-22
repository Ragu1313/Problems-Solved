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
class Pair{
    int val;
    TreeNode node;
    public Pair(int val,TreeNode node){
        this.val = val;
        this.node = node;
    }
}
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<Pair> s = new Stack<>();
        traversal = traversal+"-";
        int n = traversal.length();
        
        // TreeNode head = new TreeNode(0);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        TreeNode head = null;
        for(char ch : traversal.toCharArray()){
            if(ch=='-' && sb.toString().length()>0){
                int num = Integer.parseInt(sb.toString());
                // System.out.println("cnt "+cnt);
                sb = new StringBuilder();
                // if(!s.isEmpty()){
                while(!s.isEmpty() && s.peek().val>=cnt){
                    s.pop();
                }
                // }
                // System.out.println(num);
                TreeNode newNode  = new TreeNode(num);
                if(head==null)  head = newNode;
                if(!s.isEmpty()){
                    TreeNode temp = s.peek().node;
                    if(temp.left==null){
                        temp.left = newNode;
                    }
                    else{
                        temp.right = newNode;
                    }
                }
                
                s.push(new Pair(cnt,newNode));
                cnt = 0;
            }

            if(ch=='-'){
                // System.out.println(cnt);
                cnt++;
            }
            else if(ch!='-'){
                sb.append(ch);
            }
                
            
        }
        return head;
    }
}
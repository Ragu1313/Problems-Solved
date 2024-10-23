/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void replace(TreeNode * root ){
        unordered_map<TreeNode *,TreeNode *> m;
        unordered_map<TreeNode* ,int > pre;
        m[0] = 0;
        queue<TreeNode*> q ;
        q.push(root);
        int sum = 0;
        int dup = 0;
        TreeNode* t = new TreeNode(0);
        m[root] = t;
        pre[t] = 0;
        while(q.empty()!=1){
            int size = q.size();
            sum = 0;
            for(int i=0;i<size;i++){
                int dup1 = 0;
                TreeNode* temp = q.front();
                q.pop();
                if(temp->left){
                    sum = sum+temp->left->val;
                    m[temp->left] = temp;
                    q.push(temp->left);
                    dup1 +=temp->left->val;
                }
                if(temp->right){
                    sum = sum+temp->right->val;
                    m[temp->right] = temp;
                    q.push(temp->right);
                    dup1 +=temp->right->val;
                }
                // cout<<dup<<" "<<m[temp]->val<<" "<<pre[m[temp]]<<" "<<dup1<<"\n";
                temp->val = dup - pre[m[temp]];
                pre[temp] = dup1;
            }
            dup=sum;
        }
    }
    TreeNode* replaceValueInTree(TreeNode* root) {
        replace(root);
        return root;
    }
};
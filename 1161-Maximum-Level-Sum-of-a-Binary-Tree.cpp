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
    int maxLevel(TreeNode * root){
        int maxi = root->val;
        int c = 1;
        queue<TreeNode*> q;
        q.push(root);
        int l = 1;
        while(!q.empty()){
            int size = q.size();
            int sum = 0;
            l++;
            int flag = 0;
            for(int i=0;i<size;i++){
                TreeNode * temp = q.front();
                q.pop();
                if(temp->left){
                    flag =1;
                    sum +=temp->left->val;
                    q.push(temp->left);
                }
                if(temp->right){
                    flag = 1;
                    sum +=temp->right->val;
                    q.push(temp->right);
                }
            }
            // cout<<sum<<"\n";
            if(flag == 1 && sum>maxi){
                maxi = sum;
                c = l;
            }
        }
        return c;
    }
    int maxLevelSum(TreeNode* root) {
        return maxLevel(root);
    }
};
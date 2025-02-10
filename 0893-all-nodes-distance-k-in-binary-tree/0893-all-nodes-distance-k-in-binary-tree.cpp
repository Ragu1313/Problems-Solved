/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int->val;
 *     TreeNode ->;
 *     TreeNode *right;
 *     TreeNode(int x) :->val(x),->(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void inorder(TreeNode* root,map<TreeNode*,TreeNode*>&m){
        if(root!=NULL){
            if(root->left!=NULL){
                m[root->left] = root;
                inorder(root->left,m);
            }
            if(root->right!=NULL){
                m[root->right] = root;
                inorder(root->right,m);
            }
        }
    }
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        vector<int> res ;
        queue<TreeNode *> q;
        q.push(target);
        map<TreeNode*,TreeNode*> m;
        m[root] = NULL;
        inorder(root,m);
        unordered_set<TreeNode*> s;
        s.insert(target);
        while(!q.empty() && k-->0){
            int size = q.size();
            while(size-->0){
                TreeNode* temp = q.front();q.pop();
                if(temp->left!=NULL && s.insert(temp->left).second){
                    q.push(temp->left);
                }
                if(temp->right!=NULL && s.insert(temp->right).second){
                    q.push(temp->right);
                }
                TreeNode* par = m[temp];
                if(par!=NULL && s.insert(par).second){
                    // cout<<par->val;
                    q.push(par);
                }
            }
        }
        while(!q.empty()){
            res.push_back(q.front()->val);
            q.pop();
        }
        return res;
    }
};
// Time Complexity : O(N)
// Space Complexity : O(h) where h=height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : LOTS

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
class BSTIterator {
    stack<TreeNode *> s;
public:
    BSTIterator(TreeNode* root) {
        //stack<TreeNode> s;
        dfs(root);
    }
    
    int next() {
        TreeNode *popped = s.top();
        s.pop();
        if(popped->right!=NULL){
            dfs(popped->right);
        }
        return popped->val;
    }
    
    bool hasNext() {
        if(s.empty()){
            return false;
        }
        else{
            return true;
        }
    }
    void dfs(TreeNode* root){
        while(root!=NULL){
            s.push(root);
            root = root->left;
        }
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */

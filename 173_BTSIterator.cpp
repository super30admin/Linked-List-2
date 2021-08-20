// Time Complexity : Amortized O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class BSTIterator {
public:
    stack<TreeNode*> s;
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    int next() {
        TreeNode* node = s.top();
        s.pop();
        dfs(node->right);
        return node->val;
    }
    
    bool hasNext() {
        return !s.empty();
    }
    
    void dfs(TreeNode* root){
        while(root != NULL){
            s.push(root);
            root = root->left;
        }
    }
};

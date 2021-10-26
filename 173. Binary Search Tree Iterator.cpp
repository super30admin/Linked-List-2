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
 for next().  TC = O(h), SC = O(1)
 for hasnext().  TC = O(1), SC = O(1)
 */
class BSTIterator {
public:
    stack <TreeNode *> s;
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
    void dfs(TreeNode* root)
    {
        while(root!=NULL)
        {
            s.push(root);
            root=root->left;
        }   
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */

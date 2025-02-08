/*
TC : O(1)
SC : O (H)
*/
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
class BSTIterator
{
public:
    stack<TreeNode *> store;

    BSTIterator(TreeNode *root) : store()
    {
        dfs(root);
    }

    int next()
    {
        TreeNode *popped = store.top();
        store.pop();
        dfs(popped->right);
        return popped->val;
    }

    bool hasNext()
    {
        return !store.empty();
    }

    void dfs(TreeNode *root)
    {
        while (root != NULL)
        {
            store.push(root);
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
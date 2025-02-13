// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: BST Iterator
// Approach: Stack-based Iterative Inorder Traversal
// TC: O(1)
// SC: O(H)

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
private:
    stack<TreeNode *> s;

    void dfs(TreeNode *root)
    {
        while (root)
        {
            s.push(root);
            root = root->left;
        }
    }

public:
    BSTIterator(TreeNode *root)
    {
        dfs(root);
    }

    int next()
    {
        TreeNode *popped = s.top();
        s.pop();
        dfs(popped->right);
        return popped->val;
    }

    bool hasNext()
    {
        return !s.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
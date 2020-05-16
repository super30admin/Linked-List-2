//Time COmplexity-O(1)
//Space Complexity-O(h)
//Ran successfully on leetcode
//3 point algo is-
//1.Push all the left nodes into the stack using dfs function.
//2.When the next() function is called it'll pop out the top of the stack move to the right.

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
    stack<TreeNode*>s;
public:
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    /** @return the next smallest number */
    int next() {
        TreeNode*node=s.top();
        s.pop();
        dfs(node->right);
        return node->val;
    }
    
    /** @return whether we have a next smallest number */
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
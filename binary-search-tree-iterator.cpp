// TC = O(1)
// SC = O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    // TC = O(1), SC = O(H)
public:
    stack<TreeNode*> st; // creating own stack rather thna rec st for controlled rec
    BSTIterator(TreeNode* root) {
        dfs(root);
    }

    void dfs(TreeNode* root) {
        while(root != nullptr) { // Calling root.left till root != null, no recursive call, using while loop instead
            st.push(root);
            root = root->left;
        }
    }
    int next() { // O(1) as in line 33, >75% it is O(1)
        TreeNode* curr = st.top();
        st.pop();
        int currVal = curr->val;
        dfs(curr->right); // calling right only when left is finished (null) for controlled recursion
        return currVal;
    }
    bool hasNext() { // O(1)
        return !st.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
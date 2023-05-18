// Time Complexity : 
// next() average case O(1)
// hasNext() O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we use controlled recursion as we require to stop and proceed in our recurrsive inorder approach.


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
public:
    stack<TreeNode*>st;
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    int next() {
        TreeNode* curr = st.top();st.pop();
        dfs(curr->right);
        return curr->val;
    }
    
    bool hasNext() {
        if(!st.empty()) return true;
        return false;
    }
    void dfs(TreeNode* root)
    {
        while(root!=NULL)
        {
            st.push(root);
            root= root->left;
        }
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
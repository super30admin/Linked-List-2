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

// Time complexity is O(1) - For the next() function, On avearge, we can consider the T.C. as O(1).
//  T.C. of the hasNext() is O(1).
//  We won't be considering the time taken by the constructor as it is called only once.
// Space complexity is O(h) - h = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class BSTIterator {
    
public:
    stack<TreeNode*> st;
    
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    /** @return the next smallest number */
    int next() {
        TreeNode* returnNode = st.top();
        st.pop();
        if(returnNode->right != nullptr)
            dfs(returnNode->right);
        return returnNode->val;
    }
    
    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !st.empty();
    }
    
private:
    void dfs(TreeNode* root) {
        while(root != nullptr) {
            st.push(root);
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

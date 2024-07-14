// as discussed in class

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
    stack<TreeNode*> st;
    void dfs(TreeNode* root) {
        while(root != NULL) {
            st.push(root);
            root = root -> left;
        }
    }
public:
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    int next() {
        TreeNode* popped = st.top();
        st.pop();
        dfs(popped -> right);
        return popped -> val;
    }
    
    bool hasNext() {
        return !st.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
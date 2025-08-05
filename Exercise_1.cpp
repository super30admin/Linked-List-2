// Time Complexity: O(h) where h is the height of the binary search tree
// Space Complexity: O(h) for the stack used in the depth-first search
// Were you able to solve the problem on Leetcode?: Yes
// Did you face any challenges while solving the problem? No

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
    std::stack<TreeNode*> st;
    BSTIterator(TreeNode* root):st() {
        dfs(root);
    }

    void dfs(TreeNode* root){
        
        while(root != nullptr){
            st.push(root);
            root = root->left;
        }

    }
    
    int next() {
        TreeNode* temp = st.top();
        st.pop();

        dfs(temp->right);
        return temp->val;
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
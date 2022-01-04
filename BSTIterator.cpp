// Time Complexity :  O(1) 
// Space Complexity : O(h) where h : Height of tree.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english

/* Controlled inorder traversal using stack.
 * Push all the left childs of root in stack.
 * When hasNext() is called : return true if stack is not empty.
 * When next() is called : Pop the top element of stack and push all the left childs of right subtree and return popped element value.  
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
class BSTIterator {
public:
    stack<TreeNode*> st;
    BSTIterator(TreeNode* root) {
        insert(root);
    }
    
    int next() {
        TreeNode* node = st.top();
        st.pop();
        insert(node->right);
        return node->val;
    }
    
    bool hasNext() {
        return st.size() != 0;
    }
    
    void insert(TreeNode* root)
    {
        while (root != nullptr)
        {
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
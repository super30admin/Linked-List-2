// Time Complexity : 
// next : O(1)
// hasnext : O(1)
// constructor: O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// use a stack to store the left values of the current element.
// Process the top element and move the right subtree when needed

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
        void pushLeft(TreeNode* root){
            while(root){
                st.push(root);
                root = root->left; 
    
            }
        }
        BSTIterator(TreeNode* root) {
            pushLeft(root);
        }
        
        int next() {
            TreeNode* temp = st.top();
            st.pop();
            if(temp->right){
                pushLeft(temp->right);
            }
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
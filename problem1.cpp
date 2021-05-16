/*
next()
Time complexity - O(H) in worst case, O(1) on average
Space complexity - O(H), since we are using the stack

hasNext()
Time complexity - O(1)
Space complexity - O(1)
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
    TreeNode *node;
    stack<TreeNode*> s;
    BSTIterator(TreeNode* root) {
        node = root;
        while (node){
            s.push(node); node = node->left;
        }
    }
    
    int next() {
        TreeNode* temp = s.top();
        s.pop();
        node = temp->right;
        while (node){
            s.push(node);
            node = node->left;            
        }
        return temp->val;
    }
    
    bool hasNext() {
        return !s.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
/*
Time Complexity: O(1) 
Space Complexity: O(h)(height of the tree)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
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
    stack<TreeNode*> stck;
    BSTIterator(TreeNode* root) {
        iter(root);
    }
    
    void iter(TreeNode* node){
        while(node!=NULL){
            stck.push(node);
            node=node->left;
        }
    }
    int next() {
        TreeNode *node = stck.top();
        stck.pop();
        iter(node->right);
        return node->val;
    }
    
    bool hasNext() {
        return !stck.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
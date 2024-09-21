
// Time Complexity : Average time complexity for next() is O(1) as most of queries can be answered in constant time, but worst case
//                   we need O(h) to traverse and add all the left nodes. So ammortized time complexity is O(h)
//                   hasNext() is constant time function
// Space Complexity : O(h) h is the height of the tree
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
    stack<TreeNode*> s;
public:
    BSTIterator(TreeNode* root) {
        while(root!=NULL)
        {
            s.push(root);
            root = root->left;
        }
    }
    
    int next() {
        TreeNode* top = s.top();
        s.pop();
        TreeNode* dup = top->right;
        while(dup)
        {
            s.push(dup);
            dup = dup->left;
        }
        return top->val;
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

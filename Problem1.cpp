// Time Complexity : O(n) next() and O(1) for hasNext()
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// BST Iterator 

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
}

#include<iostream>
#include<stack>

using namespace std;

class BSTIterator {
public:
    stack<TreeNode*> s1;
    BSTIterator(TreeNode* root) {
        TreeNode *curr = root;
        while (curr != nullptr) {
            s1.push(curr);
            curr = curr->left;
        }
        return ;
    }
    
    int next() {
        TreeNode * node = s1.top();
        if (node->right != nullptr) { 
            TreeNode *curr = node->right;
            while (curr != nullptr) {
                s1.push(curr);
                curr = curr->left;
            }
            return node->val;
        }

        s1.pop();
        TreeNode *curr = node;
        while (!s1.empty() && s1.top()->right == curr) { // While curr is the right child of the top of the stack
            curr = s1.top();
            s1.pop();
        }
        return node->val;
    }

    bool hasNext() {
	    return s1.size() != 0;
    }
};
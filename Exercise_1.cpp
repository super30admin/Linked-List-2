// Time Complexity                              :  next() - O(1) , hasNext() - O(1), initialization takes O(N) time.
// Space Complexity                             :  O(N) - number of nodes. The values of the nodes are stored in a queue.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/binary-search-tree-iterator/submissions/

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
private: 
    queue<int> q;
    void inorder(TreeNode *root) {
        if(!root) return;
        inorder(root->left);
        q.push(root->val);
        inorder(root->right);
    }
public:
    
    BSTIterator(TreeNode* root) {
        inorder(root);
    }
    
    int next() {
        int nval = q.front();
        q.pop();
        return nval;
        
    }
    
    bool hasNext() {
        return !q.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
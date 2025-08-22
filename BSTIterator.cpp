#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
/*
We use lazy evaluation by only pushing left children into the stack when needed.
When next() is called, we pop the top, return its value, and push its right child’s left path. hasNext() just checks if the stack still has nodes left to process.
Lazy evaluation is usually expected in iterator problems to avoid unnecessary traversal and memory usage upfront.
*/
class BSTIterator{
 stack<TreeNode*> st;

public:
    BSTIterator(TreeNode* root) {
        dfs(root);
    }

    void dfs(TreeNode* root) {
        while(root) {
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

// Problem - Binary Search Tree Iterator
//  Time Complexity : O(1)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We use a stack to keep track of the next element
// 2. In the constructor, we add the left nodes of the root iteratively
// 3. If next() is called, we return st.top() and then dfs to right's child left
// path  of the popped value

#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};
class BSTIterator {
public:
  stack<TreeNode *> st;
  BSTIterator(TreeNode *root) { dfs(root); }

  void dfs(TreeNode *root) {
    while (root) {
      st.push(root);
      root = root->left;
    }
  }

  int next() {
    TreeNode *top = st.top();
    st.pop();
    dfs(top->right);
    return top->val;
  }

  bool hasNext() { return !st.empty(); }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */

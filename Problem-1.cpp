// Space Complexity : O(N)

// Did this code successfully run on Leetcode : Yes

// Appoarch: Lazy loading - using a stack to push only left side of the tree and 
// only if required to call the right side of the tree.

// 173

#include<bits/stdc++.h>
using namespace std;

 // Definition for a binary tree node.
 struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class BSTIterator {
private:
    stack<TreeNode*> st; 

    void dfs(TreeNode* root) {
        while (root != NULL) {
            st.push(root);
            root = root->left;
        }
    }
public:
    BSTIterator(TreeNode* root) { // O(h)
        dfs(root);
    }
    
    int next() {  // O(h) -> amortized - O(1)
        TreeNode* result = st.top();
        st.pop();
        dfs(result->right);
        return result->val;
    }
    
    bool hasNext() { //O(1)
        return !st.empty();  
    }
};


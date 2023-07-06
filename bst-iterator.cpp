// Time Complexity : avgO(1)
// Space Complexity : O(n)
// Did this code successfully run on GfG : Yes

#include <iostream>
#include <stack>
  
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class BSTIterator {
private:
    void dfs(TreeNode* node) {
        while (node != nullptr) {
            st.push(node);
            node = node->left;
        }
    }
    stack<TreeNode*> st;
public:
    BSTIterator(TreeNode* root) {
        dfs(root);
    }

    int next() {
        TreeNode* node = st.top();
        st.pop();
        dfs(node->right);
        return node->val;
    }
    
    bool hasNext() {
        return !st.empty();
    }
};
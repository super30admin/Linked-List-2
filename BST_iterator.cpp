//Time Complexity:Amortised O(1)
//Space Complexity: O(h)
#include<iostream>
#include<vector>
#include<stack>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
class BSTIterator {
public:
    stack<TreeNode*>st;
    BSTIterator(TreeNode* root) {
        traverse(root);
    }
    void traverse(TreeNode* root){
        while(root!=nullptr){
            st.push(root);
            root = root->left;
        }
    }
    
    int next() {
        TreeNode* ptr = st.top();
        st.pop();
        traverse(ptr->right);
        return ptr->val;
    }
    
    bool hasNext() {
        return !st.empty();
    }
};

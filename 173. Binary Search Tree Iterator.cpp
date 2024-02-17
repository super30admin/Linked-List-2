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

/*
Time: O(1) amortized for each function
Space: O(h)

Approach: Use lazy loading by storing the nodes from root to leaf by traversing only the left nodes in an inorder roof-to-leaf path
*/

class BSTIterator {
public:
    stack<TreeNode*> st;


    BSTIterator(TreeNode* root) {
      st.push(root);

      //only store from root to leaf following left-only path
      while(root->left != nullptr){
        root = root->left;
        st.push(root);
      }
    }

    //o(1) amortized
    //o(n) for n calls to next (n = tree nodes)
    int next() {
      TreeNode* node = st.top();     
      int ret = node->val;
      
      st.pop();

      //we are done with this node, what comes next in-order? nodes to its right
      //so go to the right node
      //that node and all the nodes to the left-path go into the stack
      if(node->right != nullptr){
        auto nd = node->right;
        st.push(nd);
        while(nd->left != nullptr){
          nd = nd->left;
          st.push(nd);
        }
      }

      return ret;

    }
    
    bool hasNext() {
        return !st.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */

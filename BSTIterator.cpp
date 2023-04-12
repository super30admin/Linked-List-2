/**
 * TC - O(n)
 * SC - O(n)
 */
class BSTIterator {
public:
    stack<TreeNode*> st;
    BSTIterator(TreeNode* root) {
    //   if(root == nullptr);
      while(root){
          st.push(root);
          root = root->left;
      }  
    }
    
    int next() {
       TreeNode* node = st.top();
       int val = node->val;
       st.pop();
       node = node->right;
       while(node){
          st.push(node);
          node = node->left;
       }
       return val;
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
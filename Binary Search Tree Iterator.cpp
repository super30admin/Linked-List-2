//Time Complexity- O(n)
//Space Complexity- O(n)

class BSTIterator {
public:
    stack<TreeNode*> st;
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    void dfs(TreeNode* root){
        while(root!=NULL){
            st.push(root);
            root=root->left;
        }
    }
    
    int next() {
        TreeNode* top=st.top();
        st.pop();
        dfs(top->right);
        return top->val;
    }
    
    bool hasNext() {
        return st.size()!=0;
    }
};
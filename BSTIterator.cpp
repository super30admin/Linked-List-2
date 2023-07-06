class BSTIterator {
public: 
    deque<TreeNode*> st;
    BSTIterator(TreeNode* root) { 
        st.push_back(root); 
        dfs(root->left); 
    }

    void dfs(TreeNode* node) {
        if(node == nullptr) return; 
        st.push_back(node); 
        dfs(node->left);  
    }
    
    int next() {
        TreeNode* node = st.back(); 
        st.pop_back();   
        dfs(node->right); 
        return node->val; 
    }
    
    bool hasNext() {
        if(!st.empty()) return true; 
        return false; 
    }
};
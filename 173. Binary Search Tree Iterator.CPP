class BSTIterator {
public:
    //TC-O(1)
    //SC-O(H)
    stack<TreeNode*> st;
    
    BSTIterator(TreeNode* root) {
        pushall(root);
    }
    
    int next() {
        auto temp=st.top();
        st.pop();
        if(temp->right){
        pushall(temp->right);
            }
        return temp->val;
    }
    
    bool hasNext() {
    if(!st.empty())return true;
        else return false;
    }
    
    void pushall(TreeNode* root){
        TreeNode* p=root;
        while(p){
            st.push(p);
             p=p->left;   
        }
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
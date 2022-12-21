// Time Complexity : O(n)
// Space Complexity : O(h)

class solution{
stack<TreeNode*>st;

BSTIterator(TreeNode* root) {
    while(root)
    {
        st.push(root);
        root=root->left;
    }
}

int next() {
    
    TreeNode*root=st.top();st.pop();
    int result=root->val;
    root=root->right;
    while(root)
    {
        st.push(root);
        root=root->left;
    }
    return result;
}

bool hasNext() {
    if(st.size()==0) return false;
    else return true;
}
}
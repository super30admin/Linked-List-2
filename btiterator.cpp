//T: O(n)
//S : O(n)
public:
    int lastSmall;
    bool firstTime;
    TreeNode* rt;
    queue<int> store;
    BSTIterator(TreeNode* root) {
        firstTime = true;
        if(root) store.push(root->val);
        rt  = root;
    }
    void iterate(TreeNode* root){
        if(root == nullptr) return ;
        iterate(root->left);
        store.push(root->val);
        iterate(root->right);
    }
    /** @return the next smallest number */
    int next() {
        if(firstTime) {
            if(!store.empty()) store.pop();
            iterate(rt);
            firstTime = false;
        }
        int elem = store.front();
        store.pop();
        return elem;
    }
    /** @return whether we have a next smallest number */
    bool hasNext() {
        if(store.empty()) return false;
        return true;
    }
};
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
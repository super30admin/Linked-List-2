//not sure of TC, maybe O(n)
//SC= O(1) due to lack of auxillary space
class BSTIterator {    
public: 
    BSTIterator(TreeNode* root) {
        while(root){
            stk.push(root);
            root = root->left;
        }
    }
    
    /** @return the next smallest number */
    int next() {
        TreeNode* p = stk.top();
        stk.pop();
        int val = p->val;
        p = p->right;
        while(p){
            stk.push(p); // FILO: think about 3-node tree
            p = p->left;
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !stk.empty();
    }
    
private:
    stack<TreeNode* > stk;
};

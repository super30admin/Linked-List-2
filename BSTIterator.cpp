// Time Complexity : o(n)
// Space Complexity : o(n) may tree can be skewed tree
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class BSTIterator {
public:
    stack<TreeNode*> stk;
    
    void insertLeft() {
        TreeNode *top = stk.top();
        while(top->left != NULL) {
            top=top->left;
            stk.push(top);
        }
    }
    
    BSTIterator(TreeNode* root) {
        stk.push(root);
        insertLeft();
    }
    
    int next() {
        int nextVal = 0;
        if(hasNext()) {
            TreeNode *top = stk.top();
            stk.pop();
            nextVal = top->val;
            if(top->right) {
                stk.push(top->right);
                insertLeft();
            }
        } else {
            stk.pop();
            nextVal = -1;
        }
        return nextVal;
    }
    
    bool hasNext() {
        return stk.size()>0?true:false;
    }
};
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO




class BSTIterator {
    private : stack<TreeNode *>myStack;
public:
    BSTIterator(TreeNode* root) {
        pushAll(root);
    }
    
    int next() {
        TreeNode *tmpNode = myStack.top();
        myStack.pop();
        pushAll(tmpNode->right);
        return tmpNode->val;
        
    }
    
    bool hasNext() {
        return !myStack.empty();
        
    }

    private:
    void pushAll(TreeNode *node)
    {
        for(; node != NULL ; myStack.push(node),node = node->left);
    }
};



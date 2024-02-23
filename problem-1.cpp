// 173. Binary Search Tree Iterator
// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
initializes a stack to store nodes and a helper function to push all left children of a given node onto the stack during initialization. 
The next() function returns the value of the top node in the stack (which is the smallest remaining value), pops it, and then pushes 
all left children of the popped node's right child onto the stack, ensuring the next smallest value is ready. The hasNext() function 
simply checks if the stack is not empty, indicating there are more elements to iterate over.


*/

class BSTIterator {
public:
    stack<TreeNode*> st;
    BSTIterator(TreeNode* root) {
        helper(root);
    }
    void helper(TreeNode* root)
    {
        while(root!=NULL)
        {
            st.push(root);
            root = root->left;
        }
        return;
    }
    int next() { // O(1)
        TreeNode* curr = st.top();
        st.pop();
        helper(curr->right);
        return curr->val;
    }
    
    bool hasNext() { // O(1)
        if(!st.empty())
            return true;
        return false;
    }
};
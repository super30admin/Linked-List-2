// Time Complexity : O(1) amortized
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We use lazy loading here i.e, we don't worry about changes to data that the iterator is 
// not currently looking. We store elements recursively (left side) into stack and whenever 
// next is called, iterator will give top element of the stack and then will go to right and
// add the nodes(if present) to the stack. 

#include<stack>

 //Definition for a binary tree node.
 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };
 
class BSTIterator {
private:
    void dfs(TreeNode* root)
    {
        while(root != nullptr)
        {
            st.push(root);
            root = root->left;
        }
    }

public:
    std::stack<TreeNode*> st;
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    int next() {
        TreeNode* re = st.top();
        st.pop();
        dfs(re->right);
        return re->val;
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
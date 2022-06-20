// Time Complexity - O(1). For 3/4th of elements the time complexity will perfectly be O(1).
// Space Complexity - I am not sure but I guess O(h) for the recursive stack?
// Problems Faced - No!
// It runs on leetcode.
class BSTIterator {
    stack<TreeNode*> st;
    
    private:
    void dfs(TreeNode* node){
        while(node){
            st.push(node);
            node = node->left;
        }
    }
public:
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    int next() {
        TreeNode* node = st.top(); st.pop();
        int temp = node->val;
        dfs(node->right);
        return temp;
    }
    
    bool hasNext() {
        return !st.empty();
    }
};
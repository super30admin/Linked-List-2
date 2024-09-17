/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
// time - O(h) worst case, O(1) - avg case; because at leaf nodes we have n/2 nodes which is 50% O(1) and one step above it is n/4 nodes which is again O(1), so 75% of the time, it is O(1);
//Space - O(h) for the constructor, but for user who has access to only next and hasnext it is O(1);
// iterators are lazy loading data structures (Most Important thing to remember)
class BSTIterator {
//private:  
private:
    stack<TreeNode*> st;   
    void dfs(TreeNode* root){
        while(root!=NULL){
            st.push(root);
            root = root->left;
        }

    }
public:
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
       
    int next() {
        TreeNode *popped = st.top();
        st.pop();
        dfs(popped->right);
        return popped->val;
        
    }
    
    bool hasNext() {
        return (!st.empty());
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */

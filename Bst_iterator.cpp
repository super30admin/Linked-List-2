// TC: O(1)->amortized. O(N) worst case;
// SC: O(N)





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
class BSTIterator {
private:
vector<int>inorder_result;
int pointer = 0;
public:
    BSTIterator(TreeNode* root) {
        stack<TreeNode*>st;
        while(!st.empty()||root!=NULL){
            if(root!=NULL){
                st.push(root);
                root = root->left;
            }else{
                root = st.top();st.pop();
                inorder_result.push_back(root->val);
                root = root->right;       
            }
        }   
    }
    int next() {
        if(hasNext())return inorder_result[pointer++];
        return -1;
    }
    bool hasNext() {
        if(pointer<inorder_result.size())return true;
        else return false;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
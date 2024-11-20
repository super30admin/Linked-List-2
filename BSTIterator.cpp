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
    vector<TreeNode*>nodes;
    int start = 0;
private:
    void inorder(TreeNode* root){
        if(root == NULL)
            return;
        
        inorder(root->left);
        nodes.push_back(root);
        inorder(root->right);
    }
public:
    BSTIterator(TreeNode* root) {
        //if we intialize the BST tree we will need an nodes list
        inorder(root);
    }
    
    int next() {
        int x = nodes[start++]->val;
        return x;
    }
    
    bool hasNext() {
        if(start <nodes.size()) return true;
        return false;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
//Time complexity:
//Has Next Function : O(1)
//Next Function : O(1)
//BSTIterator Function : O(N)

//space complexity O(N)
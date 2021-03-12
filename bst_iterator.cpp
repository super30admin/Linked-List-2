//TC: O(n) where n is number of elements
//SC: O(n) where n is number of nodes


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
public:
    
    stack<TreeNode *> s;
    
    void leftmost_node(TreeNode* root){
        while(root){
            s.push(root);
            root=root->left;
        }
    }
    
    BSTIterator(TreeNode* root) {
        leftmost_node(root);

    }
    
    int next() {
        TreeNode* top=s.top();
        s.pop();
        if(top->right)
            leftmost_node(top->right);        
        return top->val;
    }
    
    bool hasNext() {
        return s.size()>0;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
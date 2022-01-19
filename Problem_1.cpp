/*
Time Complexity:
O(1) as hasNext function will be O(1) and next function will give us O(h) in worst case scenario. But in next function,
most of the calls will be in O(1) and only a small fraction will be going for worst case. So, the average Time Complexity 
is O(1)
*/

/*
Space Complexity:
The space complexity is O(n) where n is the nodes of the tree and for worst case
our stack will be of this height
*/

/*
Approach:
If we observe clearly we have to do inorder traversal. So we created a function called dfs to
iterate through the left childs until we hit NULL and keep pushing the values in the stack.
Then we have to go back and put root of the left child in the result. So we set its value
to the top of the stack and pop this value out from the stack as we have visited it.
Then we keep doing the dfs on the right subtree and the same procedure is followed in that direction.
*/

//The code ran perfectly on leetcode

class BSTIterator {
    stack<TreeNode*> s;
public:
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    int next() {
        TreeNode *rNode = s.top();
        s.pop();
        dfs(rNode->right);
        return rNode->val;
    }
    
    bool hasNext() {
        return !s.empty();
    }
    private:
    void dfs(TreeNode *root){
        while(root != NULL){
            s.push(root);
          root = root->left;  
        } 
    }
};
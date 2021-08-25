//Time Complexity of next and hasnext is O(1)
//Space Complexity - O(h)
class BSTIterator {
public:
    stack<TreeNode*>s;
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    int next() {
        if(s.empty()){
            return -1;
        }
        TreeNode* node = s.top();
        s.pop();
        dfs(node->right);
        return node->val;
    }
    
    bool hasNext() {
        return !s.empty();
    }
    void dfs(TreeNode* root){
        while(root!=NULL){
            s.push(root);
            root=root->left;
        }
    }
};




173. Binary Search Tree Iterator

Time complexity:
O(1)
Since we push every element only once. There might be N calls and we are pushing N nodes.
So, avg TC is O(1).

Space complexity:
O(H) where H is the height of tree.


class BSTIterator {
public:
stack<TreeNode*>s;
    BSTIterator(TreeNode* root) {
        pushing(root);
    }
    void pushing(TreeNode *root){
        s.push(root);
        while(root->left) {root=root->left;s.push(root);}
    }
    int next() {
        TreeNode *temp=s.top();s.pop();
        if(temp->right){
            pushing(temp->right);
        }
        return temp->val;
    }
    
    bool hasNext() {
        return !s.empty();
    }
};

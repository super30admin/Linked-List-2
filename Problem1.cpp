// Time Complexity : O(N) N is node in tree
// Space Complexity : O(h) h is height of tree  
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Take stack to perform DFS and for BSTIterator push all left elements in stack for inorder traversal.
// 2. if next is called check if it has right subtree if yes push right child to stack and perform BSTIterator again.
// 3. if stack is empty hasnext is false else it's true.



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
    stack<TreeNode*> s;
    BSTIterator(TreeNode* root) {
        while(root !=nullptr){
            s.push(root);
            root=root->left;
        }
    }
    
    int next() {
        int ans=(s.top())->val;
        TreeNode* t=(s.top()->right);
        s.pop();
        while(t !=nullptr){
            s.push(t);
            t=t->left;
        }
        return ans;
    }
    
    bool hasNext() {
        if(s.empty()){
            return 0;
        }else{return 1;}
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
/*Implement an iterator for a binary search tree (BST) using a stack to simulate an in-order traversal.
In the constructor, push all left children of the root onto the stack to start with the leftmost node.
The next function pops a node from the stack, pushes its right child and the right child's left children onto the stack, and returns the value of the popped node.
Time Complexity: O(1) for both next and hasNext operations on average. The amortized time complexity is constant because each node is pushed and popped from the stack exactly once.
Space Complexity: O(h), where h is the height of the tree. The space required by the stack is proportional to the height of the tree, and in the worst case, it could be equal to the number of nodes in the tree for a skewed tree.
*/
#include<bits/stdc++.h>
using namespace std;
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
    stack<TreeNode*>myStack;
    BSTIterator(TreeNode* root) {
       pushAll(root);
    }
    
    bool hasNext() {
        return !myStack.empty();
    }
    
    int next() {
        TreeNode* tmpNode=myStack.top();
        myStack.pop();
        pushAll(tmpNode->right);
        return tmpNode->val;
    }
    private:
    void pushAll(TreeNode* node){
        for(;node!=NULL;myStack.push(node),node=node->left);
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
// {Approach 1}
// Time Complexity : O(1) ... for both next() and hasnext() function 
// Space Complexity : O(n) ..... extra spance is used for array
//
// {Approach 2}
// Time Complexity : O(1) .... avg. for both next() and hasnext() function 
// Space Complexity : O(h) ..... h is height os the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/binary-search-tree-iterator/description/

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
*/



/**
 * Approach 1 : Storing all nodes in an array
 * 
 * Array is created during the constructor.
 * Only drawback is that if new node is added in between to the list, it will not
 * be provided by this iterator.
 * 
*/
class BSTIterator {
    int i = 0;
    vector<TreeNode*> arr;
public:
    BSTIterator(TreeNode* root) {
        helper(root);
    }
    
    void helper(TreeNode* root){
        if(root == nullptr) return;

        helper(root->left);
        arr.push_back(root);
        helper(root->right);

        return;
    }

    int next() {
        int result = arr[i]->val;
        i++;
        return result;
    }
    
    bool hasNext() {
        if(i >= arr.size()) return false;
        return true;
    }
};



/**
 * Approach 2 : USing stack to store pointers
 * 
 * In this approach entire list is not tranverse during the construstor.
 * 
 * Helper function is used to add poniters to the stack. When some node is passed to helper;
 * helper function will add all the left nodes to the stack
 * 
 * whenever some node is poped out in next() function, helper is again called on right side of the node
 * to add more nodes to the stack.
 * 
 * This method will take care of dynamic addition of the nodes to the tree.
*/


class BSTIterator {
    stack<TreeNode*> st;
public:
    BSTIterator(TreeNode* root) {
        helper(root);
    }
    
    void helper(TreeNode* root){
        while(root != nullptr){
            st.push(root);
            root = root->left;
        }
        return;
    }

    int next() {
        int result = st.top()->val;
        TreeNode* tmp = st.top();
        st.pop();
        helper(tmp->right);
        return result;
    }
    
    bool hasNext() {
        if(st.empty()) return false;
        return true;
    }
};

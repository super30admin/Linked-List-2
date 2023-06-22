// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*controlled recursion using stack*/

// Your code here along with comments explaining your approach
/*
When the object is called create a stack that takes in value until the left subtree is null
then pop the top element give it as output 
Then traverse the right element until NULL is found. 
*/





#include<iostream>
#include<stack>

using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(): val(0),left(nullptr),right(nullptr){}
    TreeNode(int x):val(x),left(nullptr),right(nullptr){}
    TreeNode(int x,TreeNode* Left,TreeNode*Right):val(x),left(Left),right(Right){}

}TreeNode;


class BSTIterator {
    
    
public:
    stack <TreeNode* > st;

    BSTIterator(TreeNode* root) {
        while(root!=NULL){
            st.push(root);
            root= root->left;
        }

    }
    
    int next() {
        TreeNode* node{st.top()};
        int val = node->val;
        st.pop();
        node = node->right;
        while(node!=NULL){
            st.push(node);
            node = node->left;
        }
        return val;
    }
    
    bool hasNext() {
        return !st.empty();
    }
};
// Time Complexity : O(1) (ammortized time complexity, double check pls)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Minor, nothing too tough


// Your code here along with comments explaining your approach

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
     stack<TreeNode*> st;  // declaring a stack
public:
    BSTIterator(TreeNode* root) {
       
       dfs(root);   // calling bst
    }
    
    int next() {
        TreeNode* node = st.top();  // taking the top element of stack
        st.pop();
        dfs(node->right);  // calling dfs on right node
        return node->val;  // return value of node
    }
    
    bool hasNext() {
        return (!st.empty());  
    }
    
    void dfs(TreeNode* root){
          while(root!=NULL){
           st.push(root);
            root = root->left;
        }
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */

// int main(){
    
//     return 0;
// }
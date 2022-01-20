//Time Complexity O(n)
// Space Complexity O(h)(Height of the tree)(Elements in queue)(Although all the elements will never be in the queue at a time unless it has only 1 node)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

 //Definition for a binary tree node.
  struct TreeNode {
     int val;
     TreeNode *left;
    TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
 
class BSTIterator {
public:
    stack<TreeNode*> s;
    BSTIterator(TreeNode* root) {
        dfs(root);
    }
    
    int next() {
        TreeNode* top=s.top();
        s.pop();
        dfs(top->right);
        return top->val;
    }
    
    bool hasNext() {
        return !s.empty();
    }
    
    void dfs(TreeNode* root)
    {
        if(root==NULL)
        {
            return;
        }
        s.push(root);
        dfs(root->left);
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
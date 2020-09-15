//
//  main.cpp
//  173_Binary_Search_Tree_Iterator


#include <iostream>
#include <vector>
#include <stack>
#include <numeric>

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

 // store each node value in array by using inorder traversal;
class BSTIterator {
public:
    
     vector<int> nodes;
     int index;
    //TC:O(N) SC: O(N)
     BSTIterator(TreeNode* root) {
         index=0;
         inorderTraversal(root);
     }
    
     /** @return the next smallest number */
    //TC:O(1)
     int next() {
         index++;
         return nodes[index-1];
     }
    
     /** @return whether we have a next smallest number */
    //TC:O(1)
     bool hasNext() {
         if(index >= nodes.size()) return false;
         return true;
     }
    
     void inorderTraversal(TreeNode* root){
         if(root==NULL) return;
         inorderTraversal(root->left);
         nodes.push_back(root->val);
         inorderTraversal(root->right);
     }
    
};

//By tweaking inorder traversal
//SC: O(h)
class BSTIterator1 {
public:
    stack<TreeNode*> s;
    BSTIterator1(TreeNode* root) {
        inorder(root);
    }
    
    /** @return the next smallest number */
    //TC: O(h), h = height of tree
    int next() {
        TreeNode* output = s.top(); s.pop();
        if(output->right!=NULL){
                inorder(output->right);
        }
        return output->val;
    }
    
    /** @return whether we have a next smallest number */
    //TC: O(1)
    bool hasNext() {
        return !s.empty();
    }
    
    void inorder(TreeNode* root){
        while(root!=NULL){
            s.push(root);
            root=root->left;
        }
    }
    
};


int main(int argc, const char * argv[]) {
      TreeNode* root = new TreeNode(5);
      root->left = new TreeNode(3);
      root->right = new TreeNode(7);
      root->left->left = new TreeNode(2);
      root->left->right = new TreeNode(4);
      root->right->left = new TreeNode(6);
      root->right->right = new TreeNode(8);
    
      // Iterator to BST
      BSTIterator1 b(root);
    cout<<b.hasNext()<<endl;
    cout<<b.next()<<endl;
    cout<<b.next()<<endl;
    cout<<b.hasNext()<<endl;
    cout<<b.next()<<endl;
    cout<<b.hasNext()<<endl;
    cout<<b.next()<<endl;
    cout<<b.hasNext()<<endl;
    
      return 0;
    return 0;
}

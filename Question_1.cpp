#include<bits/stdc++.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
#include<unordered_map>
#include<utility>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(NULL), right(NULL) {}
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}    
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

class BSTIterator {
    TreeNode* ptr;
    
public:

    pair<TreeNode*,TreeNode*> LinkedListMaker(TreeNode* root){
        if(!root) return {NULL,NULL};
        pair<TreeNode*,TreeNode*>left_child = LinkedListMaker(root->left);
        pair<TreeNode*,TreeNode*>right_child = LinkedListMaker(root->right);
        if(left_child.second) left_child.second->right = root;
        if(right_child.second) right_child.second->right = NULL;
        root->left = NULL;
        TreeNode* last=root,*begin=root;
        if(right_child.first){
            last = right_child.second;
        }
        if(left_child.first){
            begin = left_child.first;
        }
        root->right = right_child.first;
        return {begin,last};
    }
    BSTIterator(TreeNode* root) {
        pair<TreeNode*,TreeNode*>list_ptr = LinkedListMaker(root);
        ptr = list_ptr.first;
        TreeNode* temp = new TreeNode();
        temp->right = ptr;
        ptr = temp;
    }
    
    int next() {
        ptr = ptr->right;
        return ptr->val;
    }
    
    bool hasNext() {
        return ptr->right!=NULL;
    }
};

int main(){
    TreeNode* root = new TreeNode(7);
    root->left = new TreeNode(3);
    root->right = new TreeNode(15);
    root->right->left = new TreeNode(9);
    root->right->right = new TreeNode(20);
    BSTIterator* obj = new BSTIterator(root);
    cout<<obj->next();
    cout<<obj->next();
    cout<<obj->hasNext();
    cout<<obj->next();
    cout<<obj->hasNext();
    cout<<obj->next();
    cout<<obj->hasNext();
    cout<<obj->next();
    cout<<obj->hasNext();
    return 0;
}
// Time Complexity: O(1) for next and hasNext
// Space Complexity: O(1) for LinkedListMaker
// Input: [7,3,15,null,null,9,20]
// Output: 3 7 9 15 20
// Explanation: The inorder traversal of the BST is [3,7,9,15,20]. The BSTIterator is initialized with the root node. Calling next() will return the next smallest number in the BST. Calling hasNext() will return whether there is a next number in the BST. next() and hasNext() are called in an interleaved manner.

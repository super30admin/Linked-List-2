// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

/*

The BST Iterator has 2 functions, next and hasNext. We make a vector and store the elements in an inorder 
manner. we will start iterating over the vector to get the next element. We will also check if there are
any more elements left to iterate over, if yes hasNext will return true. else it will return false

*/

// Your code here along with comments explaining your approach
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

    vector<int> li;
    int i = 0;

    void inorder(TreeNode* root){
        if(root == NULL){
            return;
        }

        inorder(root->left);
        li.push_back(root->val);
        inorder(root->right);
    }
    BSTIterator(TreeNode* root) {
        inorder(root);

        
    }
    
    int next() {
        int result = li[i];
        i++;
        return result;
        
    }
    
    bool hasNext() {
        if(i>= li.size()){
            return false;
        }
        
        return true;
        
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
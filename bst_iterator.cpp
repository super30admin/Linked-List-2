// Time Complexity : BSTIterator O(n), next O(1), has_next O(1)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class BSTIterator {
private:
    int iter = -1;
    vector<int> bst_vect;
    
public:
    // Recursive function for Inorder traversal
    void bst_rec(TreeNode* root)
    {
        if(!root)
            return;
        
        bst_rec(root->left);
        
        bst_vect.push_back(root->val);
        
        bst_rec(root->right);
        
        return;
    }
    
    // Constructor converts the Tree to an Inorder Array
    BSTIterator(TreeNode* root) {
        
        bst_rec(root);
    }
    
    // Return next node
    int next() {
        iter++;
        
        return bst_vect[iter];
    }
    
    // Check if next node available
    bool hasNext() {
        
        if(iter+1 < bst_vect.size())
            return true;
        else
            return false;
    }
};

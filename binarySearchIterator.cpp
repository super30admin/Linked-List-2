//time complexity:O(1)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using array
//any issues faced? no

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
    vector<int>res;
    int index=-1;
    BSTIterator(TreeNode* root) {
        helper(root);
    }
    void helper(TreeNode* root)
    {
        if(root==NULL)
            return;
        helper(root->left);
        res.push_back(root->val);
        helper(root->right);
    }
    
    /** @return the next smallest number */
    int next() {
        index++;
        return res[index];
    }
    
    /** @return whether we have a next smallest number */
    bool hasNext() {
        return index+1<res.size();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
// Time Complexity : O(1) average time for next() and hasNext() methods
// Space Complexity : O(H) as we are only having atmost height no.of elements in the stack at a time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/binary-search-tree-iterator/
// Submission Link: https://leetcode.com/submissions/detail/541195689/

class BSTIterator {
    stack<TreeNode*> s; 
public:
    BSTIterator(TreeNode* root) {
        s.push(root);
        
        root = root -> left;
        while(root != NULL){
            s.push(root);
            root = root -> left;
        }
    }
    
    int next() {
        TreeNode* temp = s.top();
        TreeNode* top = s.top();
        s.pop();
        
        top = top -> right;
        if(top != NULL){
            s.push(top);
            top = top -> left;
            
            while(top != NULL){
                s.push(top);
                top = top -> left;
            }
        }
        
        return temp -> val;
    }
    
    bool hasNext() {
        if(s.empty())
            return false;
        return true;
    }
};



//Time complexity: next() function we are pushing nodes in O(1) time only and for pushing total n nodes it takes 
//us O(n) time. so for one instance of next() it takes O(1) on an average

//Space complexity: O(h) h- height of the tree. space is used for storing in the stack.

//Idea: we initialize a global stack. we create a new function leftmost(root) this will
//push all the left most nodes on to the stack. now the top of this stack has the min element
//now the next() function when called it will pop the node and then pushes all the left most childs of this right child including it.
//by using leftmost(node->right) function we do that.
//by doing this we always have the min element of hte tree at a given point at the top of the stack



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
    stack<TreeNode*> st;
    void leftmost(TreeNode* node){
        while(node){
            st.push(node);
            node = node->left;
        }
    }
public:
    BSTIterator(TreeNode* root) {
        leftmost(root); //now the initial stack is ready for next() function to use it.
    }
    
    int next() {
        TreeNode* top = st.top();
        st.pop();
        if(top->right){
            leftmost(top->right);
        }
        return top->val;
    }
    
    bool hasNext() {
        if(st.empty()){
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

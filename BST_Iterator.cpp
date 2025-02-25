// Time Complexity: O(1) for next() and hasNext() functions
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. We will use a stack to store the leftmost elements of the tree.
//2. We will push the leftmost elements of the tree into the stack.
//3. When we call next(), we will pop the top element from the stack and check if it has a right child. If it has, we will push the leftmost elements of the right child into the stack.
//4. hasNext() will return true if the stack is not empty.
//5. We will keep doing this until the stack is empty.

class BSTIterator {
    private: 
        stack<TreeNode*> stack;
        void pushLeft(TreeNode* root){
            while(root != nullptr){
                stack.push(root);
                root = root -> left;
            }
        }
    public:
        BSTIterator(TreeNode* root) {
            pushLeft(root);
        }
        
        int next() {
            TreeNode* node = stack.top();
            stack.pop();
            if(node -> right != nullptr){
                pushLeft(node -> right);
            }
            return node -> val;
        }
        
        bool hasNext() {
            return !stack.empty();
        }
    };
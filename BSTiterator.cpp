// next O(1) Amortized
// has->next O(1)   TC/////  For object we do not consider it for space complexity


// Approach:
// Inorder traversal is performed in the constructor is called it first pushes all the elements on the left in to stack until null reached
// Whenever next is called on this object stack is popped and dfs function is called on right elment of this popped node
// if stack is not empty it means there exists next element

// The code implements a BSTIterator class to provide an iterator for a binary search tree (BST).

class BSTIterator {
public:
    stack<TreeNode*> q;

    // Constructor that initializes the iterator by performing a depth-first search (DFS) on the BST and pushing the left child nodes onto the stack.
    BSTIterator(TreeNode* root) {
        if (root != nullptr)
            dfs(root);
    }

    // Function to return the value of the next smallest element in the BST.
    // It retrieves the top node from the stack, pops it, performs a DFS on its right child, and returns the value.
    int next() {
        TreeNode* ans = q.top();
        q.pop();
        dfs(ans->right);
        return ans->val;
    }

    // Function to check if there are more elements to iterate.
    // It checks if the stack is empty or not.
    bool hasNext() {
        return !q.empty();
    }

    // Helper function that performs a depth-first search (DFS) starting from the given root node.
    // It pushes all the left child nodes onto the stack.
    void dfs(TreeNode* root) {
        while (root != nullptr) {
            q.push(root);
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

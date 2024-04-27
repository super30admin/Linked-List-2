//Time O(1)
 //Space O(n)
 //Leetcode: yes
 //issue seen: none
class BSTIterator {
public:
    stack <TreeNode*> st;
    void collectLeftNodes(TreeNode* node){
        while(node){
            st.push(node);
            node = node->left;
        }
    }

    BSTIterator(TreeNode* root) {
        collectLeftNodes(root);
    }
   
    
    int next() {
        TreeNode* node = st.top();
        st.pop();
        if(node->right) {
            collectLeftNodes(node->right);
        }
        return node->val;
        
    }
    
    bool hasNext() {
        if(st.empty())
           return false;
        return true;   
    }
};

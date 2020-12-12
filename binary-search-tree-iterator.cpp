//Time complexity - O(n) n- number of nodes in tree
//Space complexity - O(n)

class BSTIterator {
public:
    stack<TreeNode*> st;
    vector<int> elements;
    int idx ;
    BSTIterator(TreeNode* root) {
        idx = -1;
        while(!st.empty() || root){
            while(root){
                st.push(root);
                root=root->left;
            }
            elements.push_back(st.top()->val);
            root = st.top();
            st.pop();
            root = root->right;
        }
    }
    
    int next() {
       idx++;
       return elements[idx];
    }
    
    bool hasNext() {
        return idx+1 < elements.size();  
    }
};

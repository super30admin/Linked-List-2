// Time Complexity : constructing the iterator -O(n) , next and hasnext -O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes



class BSTIterator {
public:
    vector<int> bstIter {-1};
    vector<int>::iterator curr;
    void populateArray(TreeNode* n)
    {
        if(n==nullptr)
        {
            return;
        }
        populateArray(n->left);
        this->bstIter.push_back(n->val);
        populateArray(n->right);
    }
    
    BSTIterator(TreeNode* root) 
    {
        populateArray(root);
        curr=this->bstIter.begin();
        
    }
    
    int next() 
    {
        (this->curr)++;
        return (*curr);
    }
    
    bool hasNext() 
    {
        
        auto kt=this->curr;
        kt++;
        if(kt==bstIter.end())
        {
            return false;
        }
        return true;
    }
};

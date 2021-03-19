// TC -> O(1);
// SC -> O(1);


 class Solution
{
    public:
    void deleteNode(Node *node)
    {
       // Your code here
    //   node->data = node->next->data;
    //   node->next = node->next->next;
        *node = *(node->next);
    }

};
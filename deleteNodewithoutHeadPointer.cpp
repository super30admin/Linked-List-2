/**
 * Tc - O(1)
 * SC - O(1)
*/
class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
        del->data = del->next->data;
        del->next = del->next->next;
       // Your code here
    }

};
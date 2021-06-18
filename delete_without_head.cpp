// Time Complexity : O(1)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       Node* next_node = del->next;

       // Replicate the next node in the node to be deleted
       // Delete the next node

       del->data = next_node->data;
       del->next = next_node->next;
       
       delete(next_node);
    }
};
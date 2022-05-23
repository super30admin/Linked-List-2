// Time Complexity : o(1)
// Space Complexity : o(1)
// Did this code successfully run on GFG : YES
// Any problem you faced while coding this : NO

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       // Your code here
       Node *temp = del->next;
       del->data = del->next->data;
       del->next=del->next->next;
       temp->next=NULL;
    }

};
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
        Node *temp = del->next;
        del->data = temp->data;
		//node->val = node->next->val;
        del->next = temp->next;
		//node->next = node->next->next;
        temp->next = NULL;
        
        delete temp;
    }

};
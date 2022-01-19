/*
Time Complexity:
O(1)
*/

/*
SPace Complexity:
O(1) as we are not creating any extra space.
*/

/*
Approach:
We have to delete the node entirely. So we are maintaining
a temporary pointer pointing to the node next to the node to be deleted.
Thenw e copy the data  of the next node to the4 node to be deleted and
next pointer of the node to be deleted now points to the node next to 
the node pointed by temp. Then we finally delete the temp*/
class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       // Your code here
       Node *temp = del->next;
       del->data = temp->data;
       del->next = temp->next;
       temp->next = NULL;
       delete temp;
    }

};
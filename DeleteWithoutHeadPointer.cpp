// Time Complexity - O(1) - Accessing a value in a node is O(1) and accessing the next node sor a given node is also O(1).
// Space Complexity - O(1) - Since we are just using one 'temp' pointer to get to the solution.
// Problems Faced - No!
// It runs on geeksforgeeks.
class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       // Your code here
       Node* temp = del->next;
       del->data = temp->data;
       del->next = temp->next;
       delete temp;
    }

};
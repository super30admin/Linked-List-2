class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
        Node* temp = del->next; 
        *del = *(temp);
        delete(temp);
    }

};

//T(n)=O(1)
//S(n)=O(1)
//ran on geeks for geeks=yes



class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       int val=del->next->data;
       del->data=val;
       del->next=del->next->next;
    }

};

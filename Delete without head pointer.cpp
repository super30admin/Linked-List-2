// time: O(1)
// space: O(1)

/* Link list node 
struct Node
{
    int data;
    Node* next;
}*/

class Solution
{
    public:
    void deleteNode(Node *del_node)
    {
    	del_node -> data = del_node -> next -> data;
    	del_node -> next = del_node -> next -> next;
    }
};

//Time O(1)
//Space O(1)
//Leetcode: yes
//issue seen: none

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del_node)
    {
        Node* temp = del_node->next;
        del_node->data = temp->data;
        del_node->next = temp->next;
        free(temp);
        
    }

};

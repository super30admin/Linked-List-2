//TC: O(1)
//SC: O(1)

/*
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
}*head;
*/

// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted.
class Solution
{
    public:
    void deleteNode(Node *node)
    {
    if (node == NULL) // If linked list is empty
        return;
    else {
 
        if (node->next == NULL) {
            printf("This is last node, require head, can't "
                   "be freed\n");
            return;
        }
 
        struct Node* temp = node->next;
 
        // Copy data of the next node to current node
        node->data = node->next->data;
 
        // Perform conventional deletion
        node->next = node->next->next;
 
        free(temp);
        }
    }

};
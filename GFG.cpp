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

class Solution {
  public:
    // Function to delete a node without any reference to the head pointer.
    void deleteNode(Node* del_node) {
        // Check if the node to be deleted is not NULL and is not the last node
        if (del_node == nullptr || del_node->next == nullptr)
            return;

        Node* temp = del_node->next;       
        del_node->data = temp->data;       
        del_node->next = temp->next;       
        delete temp;
    }
};
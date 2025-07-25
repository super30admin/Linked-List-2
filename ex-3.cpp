//time complexity: O(1).. as we are only copying the data of the next node into our node 
//space complexity: O(1) .. extra temp node created is also deleted. no final extra nodes are not crerated.

//Idea: as we are not given head we don't have previous node to change the next pointer.
//but as we are given the del_node we know its next node data right!
//so copy the next node data to our node and make its next pointer to its nrext->next pointer .then the order of the linked list remains same.
//the next node will become a hanging node to the list.




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
        // Your code here
        if(del_node == nullptr || del_node->next == nullptr){// in question only they mentioned it wn't happen
            return;
        }
        Node* temp = del_node->next;
        del_node->data = temp->data;
        del_node->next = temp->next;
        delete temp;
        
    }
};

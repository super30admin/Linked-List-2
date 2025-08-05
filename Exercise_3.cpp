// Time Complexity: O(1)
// Space Complexity: O(1)
// Were you able to solve the problem on Leetcode?: Yes
// Did you face any challenges while solving the problem? No

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
    void deleteNode(Node* del_node) {
        // code here
        // If the node to be deleted is null or the next node is null,
        // we cannot perform the deletion operation.
        if (del_node == nullptr || del_node->next == nullptr){
            return;
        }
        
        // Copy the data from the next node to the current node
        // assign the next node to the current node's next pointer
        // effectively removing the next node from the list
        del_node->data = del_node->next->data;
        del_node->next = del_node->next->next;
    }
};
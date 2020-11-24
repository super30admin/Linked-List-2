// Time complexity is O(n) - n = #elements in linked list
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
// node: reference to the node which is to be deleted
void deleteNode(Node *node)
{
   // Your code here
   while(node->next->next != nullptr) {
       node->data = node->next->data;
       node = node->next;
   }
   node->data = node->next->data;
   node->next = nullptr;
}

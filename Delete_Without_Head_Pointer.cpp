// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes(ran in geeksforgeeks)
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
   // copied the next node's value to the current node. deleted the the next node
   Node *temp = node->next;
   node->data = node->next->data;
   node->next = node->next->next;
   free(temp);
}

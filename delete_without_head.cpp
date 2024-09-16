//Time Complexity-O(1)
//Space Complexity-O(1)
//Ran successfully on leetcode
//3 point algo-
//1.Make the value of the node equal to the value of the node after the one you want to delete.
//2.Then we change the next pointer of the node we want to delete to next->next.
//3.This makes sure we remove the next node, but still preserving its value at the current location

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
   node->data=node->next->data;
   node->next=node->next->next;
}


    // Student : Shahreen Shahjahan Psyche
    // Time : 
    // Space : 

    // This code ran successfully for all the test cases in Leetcode

struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
}*head;


void deleteNode(Node *node)
{
   // Your code here
   *node = *(node->next);
}

// Time Complexity :  O(1) 
// Space Complexity : O(1)
// Did this code successfully run on geeks for geeks : yes

// Three line explanation of solution in plain english

/* Copy the contents of next node to current node and delete the next node.
 */

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

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       // Your code here
       Node* temp;
       temp = del->next;
       
       del->data = temp->data;
       del->next = temp->next;
       
    }

};
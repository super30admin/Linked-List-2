// TC = O(1)
// SC = O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
       if (del == nullptr || del->next == nullptr) {
            return;
        }
       Node *toDel = del->next;
       int temp = del->next->data;
       del->next->data = del->data;
       del->data = temp;
       del->next = del->next->next;
       delete toDel;
    }

};
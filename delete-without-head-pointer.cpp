// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on GfG : Yes


#include <iostream>
  
using namespace std;

class Solution
{  
public:
    struct Node {
            int data;
            struct Node *next;
            Node(int x) {
                data = x;
                next = NULL;
            }
    };
    //Function to delete a node without any reference to head pointer.
    //Replace given node that needs to be deleted with the next node until you reach null
    void deleteNode(Node *del)
    {

       Node* curr = del;
       Node* prev;
       while(curr->next != NULL){
           Node* temp = curr->next;
           prev = curr;
           curr->data = temp->data;
           curr = temp;
       }
       prev->next = NULL;
    }

};
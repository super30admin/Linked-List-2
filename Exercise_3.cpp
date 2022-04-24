// Time Complexity                              :  O(N), where N is the number of nodes in the linked list
// Space Complexity                             :  O(1)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

// https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1


#include<bits/stdc++.h>
using namespace std;

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
        
       Node *prev = NULL;
       // replace the data in the node with the data of the node ahead of it.
       while(del->next) {
           del->data = del->next->data;
           prev = del;
           del = del->next;
       }
       if(prev) prev->next = NULL;
       delete del;
    }

};

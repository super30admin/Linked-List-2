// Time Complexity : O(1) 

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes

// Appoarch: Replacing the next value and moving the pointer to next->next.

// 237

#include<bits/stdc++.h>
using namespace std;

struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
}*head;

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       del->data = del->next->data;
       del->next = del->next->next;
    }

};
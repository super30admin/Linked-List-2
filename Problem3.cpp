// Problem - Delete without a head pointer
//  Time Complexity : O(1)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first check if list is not empty or we are not given the tail node
// 2. Then we copy the data of our next node to current node
// 3. then point our curr_node->next to del_node->next->next

#include <bits/stdc++.h>
using namespace std;

struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};

class Solution {
public:
  void deleteNode(Node *del_node) {
    // code here
    // if empty or deleting last node
    if (!del_node || !del_node->next)
      return;
    del_node->data = del_node->next->data;
    del_node->next = del_node->next->next;
  }
};

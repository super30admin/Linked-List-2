//Time Complexity :O(1)
//Space Complexity :O(1)
#include<iostream>
#include<vector>
using namespace std;
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
}*head;


class Solution {
  public:
    void deleteNode(Node* del_node) {
        if(del_node==nullptr || del_node->next == nullptr) return;
        del_node->data = del_node->next->data;
        del_node->next = del_node->next->next;
        
    }
};
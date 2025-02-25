#include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
struct Node {
    int data;
    Node *next;
    Node(int x) : data(x), next(NULL) {}
};

void deleteNode(Node* del_node) {
    // Your code here
    Node* ptr = del_node;
    Node* back_ptr = ptr;
    while(ptr->next){
        back_ptr = ptr;
        ptr->data = ptr->next->data;
        ptr = ptr->next;
    }
    back_ptr->next = NULL;
}

int main(){
    Node* head = new Node(1);
    head->next = new Node(2);
    head->next->next = new Node(3);
    head->next->next->next = new Node(4);
    Node* del_node = head->next->next;
    deleteNode(del_node);
    while(head){
        cout<<head->data<<" ";
        head = head->next;
    }
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(1)
// Input: 1->2->3->4, del_node = 3
// Output: 1->2->4
// Explanation: The node with value 3 is deleted.
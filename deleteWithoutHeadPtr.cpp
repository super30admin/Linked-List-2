#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
class Node{
public:
    int data;
    Node* next;

    Node(int data){
        this->data = data;
        this->next = nullptr;
    }
};
/*
We copy the next node's data into the current one and bypass the next node
Alters the value of the current node (not true deletion). 
Can’t be used when duplicates or references to original data matter.

*/
class Solution{
public:
    void deleteNode(Node* del_node){
        if(del_node == nullptr || del_node->next == nullptr) return;

        del_node->data = del_node->next->data;
        del_node->next = del_node->next->next;
    }
};

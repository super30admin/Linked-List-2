/*
Time Complexity: O(1), as no traversal is required.
Space Complexity: O(1), no extra space is used.*/
#include<bits/stdc++.h>
using namespace std;
/* Link list node 
struct Node
{
    int data;
    Node* next;
}*/

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
        //storing the node next to given node in a pointer.	
    	Node* temp = del->next;
    	
    	//copying the data of pointer in the given current node.
    	del->data = temp->data;
    	
    	//storing the next node to pointer in link part of current node.
    	del->next = temp->next;

    	// freeing memory.
    	free(temp);
    	
    }
};

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initial coondition of copying the element


// Your code here along with comments explaining your approach
/*
copy the next node to the current node that is to be removed
Move the pointer of current node to next to next node.
*/




#include<iostream>

using namespace std;

typedef struct ListNode{
    int val;
    ListNode* next;
    ListNode(int x):val(x),next(nullptr){}

}ListNode;

class Solution
{
    public:

    void deleteNode(ListNode* del){
        del->val = del->next->val;
        ListNode* temp = del->next;
        del->next = temp->next;
        temp->next; 
    }
};
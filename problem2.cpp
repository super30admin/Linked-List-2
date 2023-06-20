/*

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
logic of reversing from the second half of the array

// Your code here along with comments explaining your approach
Find midpoint using lsow and fast pointer
Reverse the array from the midpoint
Join the two linked list by taking one node from each of the linked list.


*/

#include<iostream>

using namespace std;

typedef struct ListNode{
    int val;
    ListNode* next;
    ListNode(int x):val(x),next(nullptr){}

}ListNode;

class Solution {
    ListNode* reverse(ListNode* head){
        if(head == NULL || head->next == NULL) return head;
        ListNode* prev{NULL},* curr{head},* fast{head->next};
        while(fast!=NULL){
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }
public:
    void reorderList(ListNode* head) {
        ListNode* slow{head};
        ListNode* fast{head};
        while(fast!=NULL && fast->next!=NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* rev = reverse(slow->next);
        slow->next = NULL;
        slow = head;
        while(rev!=NULL){
            fast = slow->next;
            slow->next = rev;
            rev = rev->next;
            slow->next->next = fast;
            slow = fast; 
        } 

    }
};
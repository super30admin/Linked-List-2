// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Reorder List 
#include<iostream>

using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    void reorderList(ListNode* head) {
        
        if(head == NULL || head->next == NULL) 
            return;
        
        ListNode *slow = head;
        ListNode *fast = head;

       while(fast->next != NULL && fast->next->next != NULL){
        slow = slow->next;
        fast = fast->next->next;
       }

       fast = slow->next;

       ListNode *prev = NULL;

       slow->next = NULL;

       while(fast != NULL){
        ListNode *next = fast->next;
        fast->next = prev;
        prev = fast;
        fast = next;

       }

       fast = prev;
       ListNode *next;
        
       while(head != NULL && fast != NULL){
        next = head->next;
        head->next = fast;
        fast = fast->next;
        head->next->next = next;
        head = next;

       }
    }
};
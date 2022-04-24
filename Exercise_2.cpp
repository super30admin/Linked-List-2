// Time Complexity                              :  O(N/2) = O(N), where N is the number of nodes in the list
// Space Complexity                             :  O(1) - if we follow the iterative approach and 
//                                                 O(N/2) if we reverse the list recursively. 
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  


// https://leetcode.com/problems/reorder-list/submissions/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
private: 
    ListNode *rhead;
public:
    void reorderList(ListNode* head) {
     
        ListNode *fast = head, *slow = head, *start = head;
        rhead = NULL;
        
        // O(N/2) = O(N)
        while(fast != NULL and fast->next != NULL) {
            fast = fast->next->next;
            slow = slow->next;
        }
        
        // O(N/2) operation
        // fast = reverse(slow) 
        reverseIterative(slow);
        
        // reorder the list - O(N/2)
        while(rhead->next != NULL) {
            ListNode *temp = start->next;
            start->next = rhead;
            start = temp;
            
            temp = rhead->next;
            rhead->next = start;
            rhead = temp;    
        }
    }
    
    // recursively reverse the list - O(N/2)
    ListNode* reverse(ListNode *head) {
        if(head->next == NULL) {
            rhead = head;
            return head;
        }
        
        ListNode *node = reverse(head->next);
        node->next = head;
        head->next = NULL;
        return head;
    }
    
    // iteratively reverse the list - O(N/2)
    void reverseIterative(ListNode *head) {
        if(!head) return;
        ListNode *prev = NULL, *curr = head;
        while(curr != NULL) {
            if(curr->next == NULL) rhead = curr;
            ListNode *temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
    }
};
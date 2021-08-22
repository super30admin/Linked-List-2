// Time Complexity : O(N) where N represents the no.of elements in the linkedlist
// Space Complexity : O(1) as we are doing the reorder inplace
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/reorder-list/
// Submission Link: https://leetcode.com/submissions/detail/542436551/

class Solution {
public:
    void reorderList(ListNode* head) {
        if(head == NULL)
            return;
        
        if(head -> next == NULL)
            return;
        
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast != NULL && fast -> next != NULL){
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        
        fast = reverseList(slow -> next);
        slow -> next = NULL;
        slow = head;
        
        while(fast != NULL){
            ListNode* temp = slow -> next;
            slow -> next = fast;
            fast = fast -> next;
            slow -> next -> next = temp;
            slow = temp;
        }
    }
    
    ListNode* reverseList(ListNode* head){
        if(head == NULL)
            return NULL;
        
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* fast = head -> next;
        
        while(fast != NULL){
            curr -> next = prev;
            prev = curr;
            curr = fast;
            fast = fast -> next;
        }
        
        curr -> next = prev;
        return curr;
    }
};
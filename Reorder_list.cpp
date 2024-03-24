// {Approach 1}
// Time Complexity : O(2n) == O(n) .... List is traversed two times 
// Space Complexity : O(n) ..... extra spance is used for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/reorder-list/description/

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
*/


/**
 * Explaianation : 
 * Center of the list os found by using two pointers slow and fast.
 * Once center is found, second half of the list is reversed.
 * Then one node from first list and one node from another list as added to the chain.
 * 
 */

class Solution {
public:
    void reorderList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return;
        ListNode* slow = head;
        ListNode* fast = head;

        while(fast->next != nullptr && fast->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }
        fast = slow->next;
        slow->next = nullptr;
        slow = head;

        fast = reverseList(fast);

        while(fast != nullptr){
            ListNode* temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }
        return;

    }

    ListNode* reverseList(ListNode* head){
        if(head == nullptr || head->next == nullptr) return head;

        /*
        ListNode* p = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return p;
        */

        ListNode* prev = nullptr;
        ListNode* current = head;

        while(current != nullptr){
            ListNode* temp = current->next;
            current->next = prev;
            prev = current;
            current = temp;
        }
        return prev;

    }
};
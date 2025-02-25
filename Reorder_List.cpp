// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

// Approach: 
// 1. Use Fast and slow pointers to find mid
// 2. Reverse the second half of linked list. 
// 3. Set curr -> next to null ptr(breaking the list into 2) and start forming connections from head to prev(which is head of second half) and so on.

class Solution {
public:
    void reorderList(ListNode* head) {
        ListNode* fast = head; 
        ListNode* slow = head;
        while(fast -> next != nullptr && fast -> next -> next != nullptr){
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        ListNode* curr = slow -> next;
        ListNode* prev = nullptr;
        while(curr != nullptr){
            ListNode* temp = curr -> next;
            curr -> next = prev;
            prev = curr;
            curr = temp;
        }
        slow -> next = nullptr;
        ListNode* two = prev;
        ListNode* one = head;
        while(one != nullptr && two != nullptr){
            ListNode* temp1 = one -> next;
            ListNode* temp2 = two -> next;
            one -> next = two;
            two -> next = temp1;
            one = temp1;
            two = temp2;
        }
    }
};
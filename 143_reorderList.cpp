// Time Complexity : O(N)
// Space Complexity :O(1)

class Solution {
public:
    void reorderList(ListNode* head) {
        if(head == NULL)
            return;
        ListNode* fast = head;
        ListNode* slow = head;
        while(fast != NULL && fast->next != NULL){
            fast = fast->next->next;
            slow = slow->next;
        }
        fast = reverseList(slow->next);
        slow->next = NULL;
        slow = head;
        while(fast != NULL){
            ListNode* temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }
    }
    
    ListNode* reverseList(ListNode* head){
        if(head == NULL)
            return head;
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* fast = head->next;
        while(fast != NULL){
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }
};

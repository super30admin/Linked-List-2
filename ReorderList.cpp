// Time Complexity - O(n) - O(n/2) + O(n/2) + O(n/2) is in the order of 'n'.
// Space Complexity - O(1) - Since we are just using two pointers('temp' and 'curr') to get to the solution
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    private:
    ListNode* reverse(ListNode* head){
        if(!head)
            return head;
        ListNode* curr = head;
        ListNode* temp = curr->next;
        
        
        while(head->next){
            head->next = temp->next;
            temp->next = curr;
            curr = temp;
            temp = head->next;
        }
        return curr;
    }
public:
    void reorderList(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast->next && fast->next->next){
            slow = slow->next;
            fast = fast->next->next;
        }

         ListNode* fast2 = reverse(slow->next);

        slow->next = NULL;
        slow = head;
        ListNode* temp;
        
        while(fast2){
            temp = slow->next;
            slow->next = fast2;
            fast2 = fast2->next;
            slow->next->next = temp;
            slow = temp;
        }
        
    }
};
// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
public:
    ListNode* middle(ListNode* head) {
        if(head==NULL || head->next==NULL) {
            return head;
        }
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast->next && fast->next->next) {
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
    ListNode* reverseList(ListNode* head) {
        if(head == NULL || head->next == NULL) {
            return head;
        }
        ListNode * a = NULL;
        ListNode * b = head;
        ListNode * c = head->next;
        
        while(c != NULL) {
            b->next = a;
            a=b;
            b=c;
            c=c->next;
        }
        
        b->next=a;
        
        return b;
    }
    void reorderList(ListNode* head) {
        if(head==NULL || head->next==NULL) {
            return ;
        }
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        ListNode* mid = middle(head);
        ListNode* tailSlow = reverseList(mid->next);
        mid->next=NULL;
        
        ListNode* tailFast = tailSlow->next;
        while(tailSlow != mid && slow!=NULL) {
            slow->next=tailSlow;
            slow=fast;
            fast=fast->next;
            tailSlow->next=slow;
            tailSlow=tailFast;
            if(tailSlow==mid)break;
            tailFast=tailFast->next;
        }
    }
};
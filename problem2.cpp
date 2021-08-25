//Time Complexity - O(N)
//Space Complexity - O(1)
class Solution {
public:
    void reorderList(ListNode* head) {
        if(head==NULL)
            return;
        ListNode* slow=head;
        ListNode* fast=head;
        //Find middle
        while(fast!=NULL&&fast->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        //Reverse part of list after mid
        fast=reverse(slow->next);
        slow->next=NULL;
        slow=head;
        //Algorithm to reorder
        while(fast!=NULL){
            ListNode* temp=slow->next;
            slow->next=fast;
            fast=fast->next;
            slow->next->next=temp;
            slow=temp;
        }
    }
    ListNode* reverse(ListNode* node){
        if(node==NULL)
            return NULL;
        ListNode* prev=NULL;
        ListNode* curr=node;
        ListNode* fast=node->next;
        while(fast!=NULL){
            curr->next=prev;
            prev=curr;
            curr=fast;
            fast=fast->next;
        }
        curr->next=prev;
        return curr;
    }
};
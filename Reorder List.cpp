//Time Complexity- O(n)
//Space Complexity- O(1)
 
class Solution {
public:
    void reorderList(ListNode* head) {
        
        ListNode* fast=head;
        ListNode* slow=head;
        ListNode* slow_prev=NULL;
        
        while(fast && fast->next){
            fast=fast->next->next;
            slow_prev=slow;
            slow=slow->next;
        }
        
        ListNode* second=NULL;
        if(fast==NULL){
            ListNode* curr=slow;
            ListNode* prev=NULL;
            ListNode* next=NULL;
            while(curr){
                next=curr->next;
                curr->next=prev;
                prev=curr;
                curr=next;
            }
            second=prev;
            slow_prev->next=NULL;
        }
        else{
            ListNode* curr=slow->next;
            ListNode* prev=NULL;
            ListNode* next=NULL;
            while(curr){
                next=curr->next;
                curr->next=prev;
                prev=curr;
                curr=next;
            }
            second=prev;
            slow->next=NULL;
        }
        
        ListNode* temp=head;
        while(temp!=NULL && second!=NULL){
            ListNode* next=temp->next;
            ListNode* second_next=second->next;
            temp->next=second;
            second->next=next;
            temp=next;
            second=second_next;
        }
    }
};
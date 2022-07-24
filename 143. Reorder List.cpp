class Solution {
public:
    //TC-O(N)
    //SC-O(1)
    ListNode* FindMiddle(ListNode* head){
        if(!head||!head->next)return head;
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast->next&&fast->next->next){
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
    ListNode* Reverse(ListNode* head){
        if(!head||!head->next)return head;
        ListNode* prev=NULL;
        ListNode* curr=head;
        ListNode* fast=head;
        while(curr){
            fast=fast->next;
            curr->next=prev;
            prev=curr;
            curr=fast;
        }
        return prev;
    }
    void reorderList(ListNode* head) {
        ListNode* middle=FindMiddle(head);
        ListNode* l2=Reverse(middle->next);
        middle->next=NULL;
        ListNode* l1=head;
        
        while(l1&&l2){
          ListNode* temp1=l1->next;
          ListNode* temp2=l2->next;
          l1->next=l2;
          l2->next=temp1;
          l1=temp1;
          l2=temp2;
        }
    
    }
};
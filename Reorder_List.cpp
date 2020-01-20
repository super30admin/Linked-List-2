Time Complexity-O(n)
Space Complexity-O(1)
Did the code run on Leetcode? Yes

class Solution {
public:
    void reorderList(ListNode* head) {
        if(head==NULL)
        {
            return;
        }
        ListNode* a=head;
        ListNode* b=head->next;
        while(b!=NULL && b->next!=NULL)
        {
            a=a->next;
            b=b->next->next;
        }
        ListNode* right=a->next;
        a->next=NULL;
        a=head;
        ListNode* prev=NULL;
        ListNode* next=NULL;
        while(right!=NULL)
        {
            next=right->next;
            right->next=prev;
            prev=right;
            right=next;
        }
        ListNode* f=NULL;
        while(prev!=NULL)
        {
            f=a->next;
            a->next=prev;
            prev=prev->next;
            a->next->next=f;
            a=f;
        }
    }
};
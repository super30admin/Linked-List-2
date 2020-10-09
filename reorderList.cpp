//time complexity:O(n)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using find middle, reverse, merge
//any issues faced? no

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        if(head==NULL)
            return;
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast!=NULL && fast->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        ListNode* prev=NULL;
        ListNode* curr=slow;
        ListNode* next;
        while(curr!=NULL)
        {
            next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
        }
        ListNode* l1=head;
        ListNode* l2=prev;
        while(l2->next!=NULL)
        {
            ListNode* temp=l1->next;
            l1->next=l2;
            l1=temp; 
            temp=l2->next;
            l2->next=l1;
            l2=temp;
        }
    }
};
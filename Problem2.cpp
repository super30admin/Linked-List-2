// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes


class Solution 
{
public:
    ListNode* reverse (ListNode* head)
    {
        if(head==nullptr && head->next==nullptr)
            return head;
        ListNode* prev=nullptr;
        ListNode* curr=head;
        ListNode* nxt=head->next;
        while(nxt !=nullptr)
        {
            curr->next=prev;
            prev=curr;
            curr=nxt;
            nxt=nxt->next;
        }
        curr->next=prev;
        return curr;
        
    }
    void reorderList(ListNode* head) 
    {
        if(head->next==nullptr)
        {
            return;
        }
        ListNode* iter=head;
        ListNode* slow=head;
        ListNode* fast=head;
        int n=0;
        while(iter!=nullptr)
        {
            n++;
            iter=iter->next;
        }
        if(n%2==0)
        {
            while(fast->next->next!=nullptr)
            {
                slow=slow->next;
                fast=fast->next->next;
            }
        }
        else
        {
             while(fast->next!=nullptr)
            {
                slow=slow->next;
                fast=fast->next->next;
            }
        }
        fast=reverse(slow->next);
        slow->next=nullptr;
        slow=head;
        while(fast!=nullptr)
        {
            ListNode *temp=slow->next;
            slow->next=fast;
            fast=fast->next;
            slow->next->next=temp;
            slow=temp;
        }
        
    }
    

};

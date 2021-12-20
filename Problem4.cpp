// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes


class Solution
{
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) 
    {
        ListNode *iter1=headA;
        ListNode *iter2=headB;
        ListNode *iter3;
        int m=0;
        int n=0;
        while(iter1!=nullptr)
        {
            m++;
            iter1=iter1->next;
        }
        while(iter2!=nullptr)
        {
            n++;
            iter2=iter2->next;
        }
        int dif=abs(m-n);
        if(m>=n)
        {
            iter3=headA;
            iter1=headB;
        }
        else
        {
            iter3=headB;
            iter1=headA;
        }
        for(int i=0;i<dif;i++)
        {
            iter3=iter3->next;
        }
        while(iter3!=nullptr && iter1!=nullptr)
        {
            if(iter3 == iter1)
            {
                return iter3;
            }
            iter3=iter3->next;
            iter1=iter1->next;
        }
        return nullptr;
    }
};

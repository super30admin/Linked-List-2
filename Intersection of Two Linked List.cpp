Time Complexity-O(n)
Space Complexity-(1)
Did the code run on Leetcode? Yes

class Solution {
public:
    int size1;
    int size2;
    int sizeoflinkedlist(ListNode* a)
    {
        int count=0;
        if(a==NULL)
        {
            return 0;
        }
        while(a!=NULL)
        {
            count++;
            a=a->next;
        }
        return count;
    }
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        size1=sizeoflinkedlist(headA);
        size2=sizeoflinkedlist(headB);
        int diff=size1-size2;
        ListNode* a=headA;
        ListNode* b=headB;
        cout<<size1;
        if(diff>0)
        {
            while(diff!=0)
            {
                a=a->next;
                diff--;
            }
        }
        if(diff<0)
        {
            while(diff!=0)
            {
                b=b->next;
                diff++;
            }
        }
        while(a!=NULL &&b!=NULL)
        {
            if(a==b){
                return a;
                break;
            }
            a=a->next;
            b=b->next;
        }
        return NULL;
    }
};
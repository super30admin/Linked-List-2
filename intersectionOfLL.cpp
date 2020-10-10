// Time Complexity : O(M+N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int l1=0,l2=0,x;
        ListNode *start1,*start2;
        start1=headA;
        start2=headB;
        
        while( start1!=NULL)
        {
            start1=start1->next;
            l1++;
        }
        
        while(start2!=NULL)
        {
            start2=start2->next;
            l2++;
        }
        
        if(l1>l2)
        {
             x=l1-l2;
            while(x>0)
            {
                headA=headA->next;
                x--;
            }
        }
        else
        {
            x=l2-l1;
         while(x>0)
            {
                headB=headB->next;
                x--;
            }
        }
        
        while(headA!=NULL && headB!=NULL)
        {
            if(headA==headB)
                return headA;
            
            headA=headA->next;
            headB=headB->next;
        }
        return NULL;
    }
};
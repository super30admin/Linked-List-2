
// Time Complexity : O(m+n) m, n is length of two linked lists respectively
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
        ListNode* p1 = headA;
        ListNode* p2 = headB;
        int lenA = 0;
        int lenB = 0;
        while(p1)
        {
            lenA++;
            p1 = p1->next;
        }

        while(p2)
        {
            lenB++;
            p2 = p2->next;
        }

        if(lenA < lenB)
        {
            int diff = lenB - lenA;
            p2 = headB;
            while(diff>0)
            {
                p2 = p2->next;
                diff--;
            }
            p1 = headA;
        }
        else if(lenA > lenB)
        {
            int diff = lenA - lenB;
            p1 = headA;
            while(diff>0)
            {
                p1 = p1->next;
                diff--;
            }
            p2 = headB;
        }
        else {
            p1 = headA;
            p2 = headB;
        }
        
        while(p1!=NULL)
        {
            if(p1==p2)
                return p1;
            p1=p1->next;
            p2=p2->next;
        }
    return NULL;
    }
};
//TC: O(m+n)
//SC: O(1)

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

        int lengthA = 0;
        int lengthB =0;

        ListNode* curr = headA;

        while(curr!=NULL)
        {
            curr = curr->next;
            lengthA++;
        }
        
        curr = headB;

        while(curr!=NULL)
        {
            curr = curr->next;
            lengthB++;
        }

        while(lengthA>lengthB)
        {
            headA=headA->next;
            lengthA--;
        }

         while(lengthB>lengthA)
        {
            headB=headB->next;
            lengthB--;
        }

        while(headA!=headB)
        {
            headA=headA->next;
            headB=headB->next;
        }

        return headB;
    }
};
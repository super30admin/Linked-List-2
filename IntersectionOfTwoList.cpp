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
        //Initialize the two pointers to the head of both
        ListNode *pA = headA;
        ListNode *pB = headB;
        // iterate till the headA == headB
        while(pA!=pB)
        {
            if(pA == NULL)
                pA = headB;
            else
              pA = pA->next;
            if(pB == NULL)
                pB = headA;
            else
                pB = pB->next;
              
        }
        return pA;
    }
};
//Time complexity O(n)+O(M)
//Space complexity O(1)
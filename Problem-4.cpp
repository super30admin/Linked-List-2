

160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


TC O(n)
SC O(1)


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
        int lenA=0, lenB=0;
        
        ListNode *cur = headA;
        while(cur != NULL) {
            cur = cur->next;
            lenA++;
        }
        cur = headB;
        while(cur != NULL) {
            cur = cur->next;
            lenB++;
        }        

        while (lenA > lenB) {
            headA = headA->next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB->next;
            lenB--;
        }    
        while(headA != headB) {
            headA = headA->next;
            headB = headB->next;
        }    
        return headA;
    }
};

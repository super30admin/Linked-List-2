// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we find the both lengths and then we traverse the larger list such that both pointers should be at equidistance from the end.
// we match the pointers and return the point of intersection.

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
        if(headA==NULL || headB==NULL) return NULL;
        ListNode* curr = headA;
        int lenA=0;
        while(curr!=NULL)
        {
            lenA++;
            curr= curr->next;
        }
        int lenB=0;
        curr = headB;
        while(curr!=NULL)
        {
            lenB++;
            curr = curr->next;
        }
        while(lenA>lenB)
        {
            lenA--;
            headA=headA->next;
        }
        while(lenB>lenA)
        {
            lenB--;
            headB=headB->next;
        }
        while(headA!=headB)
        {
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};
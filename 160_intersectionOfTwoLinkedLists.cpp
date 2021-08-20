// Time Complexity : O(M + N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA == NULL || headB == NULL){
            return headA;
        }
        int lenA=0, lenB=0;
        ListNode* curr = headA;
        while(curr != NULL){
            curr = curr->next;
            lenA++;
        }
        curr = headB;
        while(curr != NULL){
            curr = curr->next;
            lenB++;
        }
        while(lenA > lenB){
            headA = headA->next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB->next;
            lenB--;
        }
        while(headA != headB){
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};

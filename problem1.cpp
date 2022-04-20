//

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
        
        
        int lenA = 0;
        int lenB = 0;
        ListNode* tempA = headA;
        ListNode* tempB = headB;
        
        while(tempA != NULL){
           tempA = tempA->next;
           lenA++; 
        }
        
        while(tempB != NULL){
            tempB = tempB->next;
           lenB++; 
        }
        
        while(lenA > lenB) {
            lenA--;
            headA= headA->next;
        }
        
         while(lenB > lenA) {
            lenB--;
            headB= headB->next;
        }
        
        while(headA != headB) {
            headA= headA->next;
            headB= headB->next;
        }
        
        return headA;
        
        
    }
};
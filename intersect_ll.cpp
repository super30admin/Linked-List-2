//TC: O(n+m), where n and m are lengths of the linked lists
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
        
        
        ListNode *tempA = headA;
        ListNode *tempB = headB;
        
        if(tempA == NULL || tempB == NULL)
            return NULL;
        
       
        while(tempA != tempB && tempA != NULL && tempB != NULL){
            
            tempA = tempA->next;
            tempB = tempB->next;   
            
            if(tempA == tempB)
                return tempA;           //handles non intersecting cases as well.
            
            if(tempA == NULL)
                tempA = headB;
            
            if(tempB == NULL)
                tempB = headA;
            
            
            
        }
        
        return tempA;
        
    }
};
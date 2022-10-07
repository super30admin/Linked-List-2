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
        
        int lena = 0;
        int lenb = 0;
        ListNode* tempA = headA;
        ListNode* tempB = headB;
        
        while(tempA->next !=NULL){
            tempA = tempA->next;
            lena++;
        }
        
        while(tempB->next !=NULL){
            tempB = tempB->next;
            lenb++;
        }
        
        if(lena>lenb){
            int count = 0;
            while(count<lena-lenb){
                headA = headA->next;
               count++;
            }
            while(headA!=headB){
                headA= headA->next;
                headB= headB->next;  
            }
            return headA;
            
        }
        
        else if(lena<lenb){
            int count = 0;
            while(count<lenb-lena){
                headB = headB->next;
                count++;
            }
            while(headA!=headB){
                headA= headA->next;
                headB= headB->next;  
            }
            return headA;
            
        }
        else{
            while(headA!=headB){
                headA= headA->next;
                headB= headB->next;  
            }
            return headA;
        }
        
        
    }
};

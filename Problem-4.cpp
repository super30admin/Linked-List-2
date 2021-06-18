//TC = O(n+m)where m &n are lengths of linked lists
//SC = O(1)
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* a = headA;
        ListNode* b = headB;
        
        while(a != b){
        	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a ==NULL? headB : a->next;
            b = b ==NULL? headA : b->next; 
        }
        
     return a;
    
    }
};

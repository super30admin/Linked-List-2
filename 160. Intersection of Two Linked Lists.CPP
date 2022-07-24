class Solution {
public:
    //tc-O(N)
    //SC-O(1)
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *p=headA;
        ListNode *q=headB;
        
        
        while(p!=q){
        if(p==NULL){
            p=headB;
        }
        else
            p=p->next;
         if(q==NULL){
            q=headA;
        }
        else
            q=q->next;
        
        }
        return p;
    }
   
};
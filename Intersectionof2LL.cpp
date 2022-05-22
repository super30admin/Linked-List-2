//TC = O(K), K = max(A,B)
//SC = O(1)
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode *p1 = headA;
        ListNode *p2 = headB;
        while(p1!=NULL) {
            lenA++;
            p1=p1->next;
        }
        while(p2!=NULL) {
            lenB++;
            p2=p2->next;
        }
        p1=headA;
        p2=headB;
        int diff=0;
        if(lenA>lenB){
            diff = lenA - lenB;
            while(diff!=0){
                p1=p1->next;
                diff--;
            }
        } 
        else{
            diff = lenB - lenA;
           while(diff!=0){
                p2=p2->next;
                diff--;
            }
        }
        while(p1!=NULL && p2!=NULL){
            if(p1==p2) return p1;
            p1=p1->next;
            p2=p2->next;
        }
        return NULL;
    }
};

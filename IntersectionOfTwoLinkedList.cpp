// TC - O(n)
// Sc - O(1)

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int length1 = getLinkedListLength(headA);
        int length2 = getLinkedListLength(headB);
        int dif = abs(length1 - length2);
        if(length1>length2){
            while(dif){
                headA = headA->next;
                dif--;
            }
        }
         if(length1<length2){
            while(dif){
                headB = headB->next;
                dif--;
            }
        }
        while(headA != headB){
            headA = headA->next;
            headB = headB->next;
        }
    return headA;
        
    }

    int getLinkedListLength(ListNode *headA) {
        int count = 0;
         while(headA){
           headA = headA -> next;
           count++;
       }
        return count;
    }
};